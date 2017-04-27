package xtu.library.dao.reader;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtu.library.dao.base.BaseDao;
import xtu.library.entity.Administrator;
import xtu.library.entity.Reader;

/**
 * 
 * 读者的dao层实现
 *
 */
@Repository(value = "readerDao")
public class ReaderDaoImpl extends BaseDao implements IReaderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 保存读者信息
	 */
	@Override
	public void saveReader(Reader reader) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.persist(reader);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * 通过名字查找读者信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Reader> checkByName(String name) {
		Session session = sessionFactory.openSession();
		List<Reader> readerList = null;
		try {
			readerList = session.createQuery("select r from Reader r where r.rName = :name").setParameter("name", name)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return readerList;
	}

	/*
	 * 根据id查找对应的读者
	 */
	@Override
	public Reader findByRid(Integer rId) {
		Session session = sessionFactory.openSession();
		Reader reader = null;
		 try {
			reader = (Reader) session.createQuery("select r from Reader r where rId = :rid").setParameter("rid", rId)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return reader;
	}
	
	/*
	 * 根据id来更新一个读者的信息
	 */
	@Override
	public void updateReader(Reader reader){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(reader);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reader> listAllReader() {
		List<Reader> readerList = null;
		Session session = sessionFactory.openSession();
		
		try {
			readerList = session.createQuery("select new Reader(r.rId,r.rName,r.rSex,r.rNo,r.rLBID,r.tType,"+
			"r.rDept,r.rPref,r.rGrade,r.rCreateDate) from Reader r ").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return readerList;
	}

	@Override
	public Reader findByRNo(Integer RNO) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Reader reader = (Reader) session.createQuery("select r from Reader r where rNo = :rNo")
				.setParameter("rNo", RNO).uniqueResult();
		session.close();
		return reader;
	}


}
