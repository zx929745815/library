package xtu.library.dao.borrowmessage;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtu.library.dao.base.BaseDao;
import xtu.library.entity.Book;
import xtu.library.entity.BorrowMessage;

@Repository(value = "borMsgDao")
public class BorrowMsgDaoImpl extends BaseDao implements IBorrowMsgDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public List<BorrowMessage> queryBorrowMsg(int rId,int pageIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stu
		Session session = sessionFactory.openSession();
		int offset = (pageIndex-1)*pageSize;
		/*String hql = "select bm from ReaderCard rc left join rc.  rc "
				+ "where rc.r_id = :id";*/
		String sql = "select bm.mId as{bm.mId},bm.bId as {bm.bId},bm.bookISBN as {bm.bookISBN},bm.bookName as {bm.bookName},"
				+ "bm.bookPrice as {bm.bookPrice},bm.bookPublish as {bm.bookPublish},bm.borrowDate as {bm.borrowDate},bm.borrowState as {bm.borrowState} "
				+ "from borrowmessage bm natural join readercard rc "
				+ "where rc.r_id = :id";
		Query query = session.createSQLQuery(sql).setParameter("id", rId).addEntity(BorrowMessage.class);
		//query.setMaxResults(pageSize);
		//query.setFirstResult(offset);
		List<BorrowMessage> msgList = queryForPage(query, pageIndex, pageSize);
		//@SuppressWarnings("unchecked")
		//List<BorrowMessage> msgList = query.getResultList();
		return msgList;
	}

	@Override
	public int getMsgCount(int rId) throws Exception {
		Session session = sessionFactory.openSession();
		String sql = "select count(*) from borrowmessage bm natural join readercard rc where rc.r_id = :id ";
		Query query = session.createSQLQuery(sql).setParameter("id", rId);
		Number num = (Number) query.getSingleResult();
		session.close();
		return num.intValue();
	}
	@Override
	public int getMsgCount() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "select count(m) from BorrowMessage m";
		Number num = (Number) session.createQuery(hql).getSingleResult();
		session.close();
		return num.intValue();
	}


	@Override
	public List<BorrowMessage> queryBorrowMsg(int pageIndex,int pageSize) throws Exception{
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgList = null;
		Session session = sessionFactory.openSession();
		String hql = "select m from BorrowMessage m order by m.borrowDate desc";
		Query query = session.createQuery(hql,BorrowMessage.class);
		borMsgList = queryForPage(query, pageIndex, pageSize);
		session.close();
		return borMsgList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> queryBorBook(Integer cId) throws Exception{
		// TODO Auto-generated method stub
		List<Book> bookList = null;
		Session session = sessionFactory.openSession();
		
		String hql = "select new Book(b.bId,b.bookISBN,b.bookName,b.bookPublish) "
				+ "from BorrowMessage b "
				+ "where b.borrowState = 0 and b.rCard.cId=:cId ";
		
		Query query = session.createQuery(hql).setParameter("cId", cId);
		bookList = query.getResultList();
		session.close();
		return bookList;
	}

	@Override
	public List<BorrowMessage> queryBorMsgByCid(Integer cId) throws Exception {
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgList = null;
		Session session = sessionFactory.openSession();
		String hql = "select new BorrowMessage(b.mId,b.bId,b.bookISBN,b.bookName,b.bookPrice,"
				+ "b.bookPublish,b.borrowDate,b.borrowState)  "
				+ "from BorrowMessage b "
				+ "where b.borrowState = 0 and b.rCard.cId=:cId ";
		Query query = session.createQuery(hql).setParameter("cId", cId);
		borMsgList = query.getResultList();
		session.close();
		return borMsgList;
		
	}

	@Override
	public BorrowMessage queryBorMsgByMid(Integer mId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		BorrowMessage borMsg = null;
		String hql = "select m from BorrowMessage m where m.mId =:id";
		Query query = session.createQuery(hql,BorrowMessage.class).setParameter("id", mId);
		borMsg = (BorrowMessage) query.getSingleResult();
		session.close();
		return borMsg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowMessage> queryOverduBorMsg() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<BorrowMessage> borMsgList = null;
		String sql = "select mId,bId,bookISBN,bookName,bookPrice,bookPublish,borrowDate,borrowState,rNo,rName,c_id  "
				+ "from borrowmessage "
				+ "where TO_DAYS(NOW()) - TO_DAYS(borrowDate)>=1";
		Query query = session.createNativeQuery(sql,BorrowMessage.class);
		
		borMsgList = query.getResultList();
		session.close();
		return borMsgList;
	}

	@Override
	public List<BorrowMessage> queryOverduBorMsgByCid(Integer cId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<BorrowMessage> borMsgList = null;
		String sql = "select mId,bId,bookISBN,bookName,bookPrice,bookPublish,borrowDate,borrowState,rNo,rName,c_id,fine "
				+ "from borrowmessage "
				+ "where TO_DAYS(NOW()) - TO_DAYS(borrowDate)>=1 and borrowState = 0 and c_id = :cId";
		Query query = session.createNativeQuery(sql,BorrowMessage.class).setParameter("cId", cId);
		borMsgList = query.getResultList();
		session.close();
		return borMsgList;
	}


	


}
