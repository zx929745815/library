package xtu.library.dao.book;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtu.library.dao.base.BaseDao;
import xtu.library.entity.Book;

@Repository(value = "bookDao")
public class BookDaoImpl extends BaseDao implements IBookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Book> listAllBooks() throws Exception {
		return find("select b from Book b");
	}

	@Override
	public int getBookCount(String keyword,String condition) throws Exception {
	    String hql = "";
		if(condition.equals("byName")){
			hql = "select count(b) from Book b where b.bName like :name";
		}else if(condition.equals("byType")){
			hql = "select count(b) from Book b where b.bType like :type";
		} else{
			hql = "select count(b) from Book b where b.bISBN like :isbn";
		}
		return getCount(hql,keyword);

	}
	@Override
	public int getBookCount() throws Exception {
		 return getCount("select count(b) from Book b");
	}

	@Override
	public Book findByISBN(Integer ISBN) throws Exception {
		// TODO Auto-generated method s
		Book book = null;
		Session session = sessionFactory.openSession();
		book = (Book) session.createQuery("select b from Book b where b.bISBN = :ISBN").setParameter("ISBN", ISBN)
				.getSingleResult();
		session.close();
		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByName(String name,int pageindex, int length) throws Exception {
		// TODO Auto-generated method stub
		List<Book> bookList = null;
		Session session = sessionFactory.openSession();
		String hql = "select b from Book b where b.bName like :name";
		Query query = session.createQuery(hql, Book.class);
		query.setParameter("name", "%" + name + "%");
		bookList = queryForPage(query,pageindex, length);
		session.close();
		return bookList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Book> bookList = null;
		Session session = sessionFactory.openSession();
		String hql = "select b from Book b where b.bName like :name";
		Query query = session.createQuery(hql, Book.class);
		query.setParameter("name", "%" + name + "%");
		bookList = query.getResultList();
		session.close();
		return bookList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByType(String type) throws Exception {
		Session session = sessionFactory.openSession();
		List<Book> bookList = null;
		String hql = "select b from Book b where b.bType like :type";
		bookList = session.createQuery(hql).setParameter("type", "%" + type + "%").getResultList();
		session.close();
		return bookList;
	}

	@Override
	public List<Book> queryForPage(int pageindex, int length) throws Exception {
		Session session = sessionFactory.openSession();
		String hql = "select b from Book b ";
		Query query = session.createQuery(hql,Book.class);
		return queryForPage(query,pageindex, length);
	}

	@Override
	public Book findByBid(Integer bId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "select b from Book b where b.bId = :id";
		Query query = session.createQuery(hql,Book.class).setParameter("id", bId);
		Book book =  (Book) query.getSingleResult();
		session.close();
		return book;
	}



}
