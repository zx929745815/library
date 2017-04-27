package xtu.library.dao.notice;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtu.library.dao.base.BaseDao;
import xtu.library.entity.Notice;

@Repository(value = "noticeDao")
public class NoticeDaoImpl extends BaseDao implements INoticeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createNotice(Notice notice) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(notice);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Notice> queryNotices(int pageIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "select n from Notice n order by n.createDate desc";
		Query query = session.createQuery(hql);
		List<Notice> noticeList = queryForPage(query, pageIndex, pageSize);
		session.close();
		return noticeList;
	}

	@Override
	public int getNoticeCount() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "select count(n) from Notice n";
		Number num = (Number) session.createQuery(hql).getSingleResult();
		session.close();
		return num.intValue();
	}

}
