package xtu.library.service.book;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import xtu.library.dao.book.IBookDao;
import xtu.library.entity.Book;

@Service(value = "bookService")
public class BookServiceImpl implements IBookService{
	@Autowired
	private IBookDao bookDao;

	@Override
	public boolean addBook(Book book) {
		//添加书籍的时间为当前的时间
		book.setbDate(new Date());
		//起始副本书和总数相等
		book.setbCopy(book.getbTol());
			try {
				bookDao.save(book);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public List<Book> listAllBooks() {
		List<Book> bookList = null;
		try {
		  bookList = bookDao.listAllBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public int getBookCount() {
		try {
			return bookDao.getBookCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public int getBookCount(String keyword,String condition ) {
		try {
			return bookDao.getBookCount(keyword,condition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Book> queryBookList(int pageindex,int length) {
		// TODO Auto-generated method stub
		try {
			return bookDao.queryForPage(pageindex, length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> queryByName(String name,int pageindex, int length) {
		List<Book> bookList = null;
		try {
			bookList = bookDao.findByName(name,pageindex,length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
	@Override
	public List<Book> queryByName(String name) {
		List<Book> bookList = null;
		try {
			bookList = bookDao.findByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public Book queryByISBN(Integer ISBN) {
		Book book = null;
		try {
			book = bookDao.findByISBN(ISBN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;		
	}

	@Override
	public List<Book> queryByType(String type) {
		// TODO Auto-generated method stub
		List<Book> bookList = null;
		try {
			bookList = bookDao.findByType(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public Book queryById(Integer id) {
		Book book = new Book();
		try {
			book = bookDao.findByBid(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		try {
			bookDao.update(book);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		try {
			bookDao.delete(book);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	
}
