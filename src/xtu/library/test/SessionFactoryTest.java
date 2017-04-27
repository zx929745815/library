package xtu.library.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xtu.library.entity.Reader;

public class SessionFactoryTest {
	public static void main(String[] args) {
	    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory = ac.getBean("sessionFactory",SessionFactory.class);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Reader r = new Reader();
		r.setrName("张三三");
		r.setrPwd("12345");
		r.setrNo(2013551822);
		session.persist(r);
		session.getTransaction().commit();
		session.close();
	}
}
