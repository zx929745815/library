package xtu.library.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import xtu.library.dao.reader.IReaderDao;
import xtu.library.dao.reader.ReaderDaoImpl;
import xtu.library.entity.BorrowMessage;
import xtu.library.entity.Reader;
import xtu.library.entity.ReaderCard;
import xtu.library.web.util.HibernateUtil;

public class ReaderDaoTest {
	
	IReaderDao dao = new ReaderDaoImpl();
	
	@Test
	public void saveTest(){
		Reader r = new Reader();
		r.setrName("周玉冰");
		r.setrPwd("12345");
		r.setrNo(2013551822);
		System.out.println("r");
		dao.saveReader(r);
	}
	
	@Test
	public void borrowTest(){
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction();
		
		Reader reader = new Reader();
		reader.setrName("test");
		reader.setrPwd("test");
		ReaderCard readerCard = new ReaderCard();
		BorrowMessage borrow = new BorrowMessage();
		borrow.setBookName("test");
		borrow.setBookPublish("test");
		readerCard.getBroMsgList().add(borrow);
		//reader.setReaderCard(readerCard);
		session.persist(reader);
		session.getTransaction().commit();
		session.close();
	}

}
