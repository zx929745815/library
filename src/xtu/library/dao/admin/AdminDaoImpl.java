package xtu.library.dao.admin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtu.library.dao.base.BaseDao;
import xtu.library.entity.Administrator;

@Repository(value="adminDao")
public class AdminDaoImpl  implements IAdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * 通过姓名来查找管理员列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> findByName(String name) {
		List<Administrator> adminList = null;
		Session session = sessionFactory.openSession();
		try {
			adminList = session.createQuery("select a from Administrator a where a.aName = :name")
					.setParameter("name", name).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminList;
	}

	@Override
	public void saveAdmin(Administrator admin) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.persist(admin);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		
	}

}
