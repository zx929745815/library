package xtu.library.dao.base;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author 郑旭
 * 下午5:54:50
 */
public class BaseDao implements IBaseDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * method to insert data
	 */
	public <T> void save(T object) {
		// create a hibernate session
		Session session = sessionFactory.openSession();
		try {
			// create transaction
			session.beginTransaction();
			// save the object into database
			session.save(object);
			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {// if has the excption than rollback
			session.getTransaction().rollback();
			throw e;
		} finally{
			session.close();
		}
	}
	
	/*
	 * method to update
	 */
	public <T> void update(T object){
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally{
			session.close();
		}
	}
	
	/*
	 * method to delete
	 */
	public <T> void delete(T object){
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;//如果不向外抛出则会隐藏掉这个异常
		} finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql){
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			return session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		} finally{
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public int getCount(String hql,String keywords) throws Exception {
		Session session = sessionFactory.openSession();
		keywords = "%" + keywords + "%";
		Number num = (Number) session.createQuery(hql).setParameter(0, keywords).uniqueResult();
		session.close();
		return num.intValue();
	}
	@Override
	public int getCount(String hql) {
		Session session = sessionFactory.openSession();
		Number num = (Number) session.createQuery(hql).uniqueResult();
		session.close();
		return num.intValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForPage(Query query, int pageindex,int length) throws Exception {
		// TODO Auto-generated method stub
		List<T> resultList = null;
		Session session = sessionFactory.openSession();
		int offset = (pageindex-1)*length;
		query.setMaxResults(length);
		query.setFirstResult(offset);
		resultList =  query.getResultList();
		session.close();
		return resultList;
	}





	
}
