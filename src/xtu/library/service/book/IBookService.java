package xtu.library.service.book;

import java.util.List;

import xtu.library.entity.Book;

public interface IBookService {
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
	boolean addBook(Book book);
	
	/**
	 * 列出所有的书籍信息
	 * @return
	 */
	List<Book> listAllBooks();
	
	/**
	 * 查询所有书籍记录的条数,可用于分页
	 * @return
	 */
	int getBookCount();
	int getBookCount(String keyword,String condition);
	
	/**
	 * 图书的分页查询
	 * @param offset
	 * @param length
	 * @return
	 */
	List<Book> queryBookList(int pageindex,int length);
	
	/**
	 * 按名字查询图书
	 * @param name
	 * @return
	 */
	List<Book> queryByName(String name,int pageindex, int length);
	List<Book> queryByName(String name);
	
	/**
	 * 按ISBN精确查找
	 * @param ISBN
	 * @return
	 */
	Book queryByISBN(Integer ISBN);
	
	/**
	 * 按类别查找
	 * @param type
	 * @return
	 */
	List<Book> queryByType(String type);
	
	/**
	 * 通过id来查询图书
	 * @param id
	 * @return
	 */
	Book queryById(Integer id);
	
	/**
	 * 书籍更新
	 * @param book
	 * @return
	 */
	boolean updateBook(Book book);
	
	/**
	 * 删除一本书
	 * @param book
	 * @return
	 */
	boolean deleteBook(Book book);
}
