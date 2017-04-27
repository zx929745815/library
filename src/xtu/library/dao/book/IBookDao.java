package xtu.library.dao.book;

import java.util.List;

import xtu.library.dao.base.IBaseDao;
import xtu.library.entity.Book;

public interface IBookDao extends IBaseDao{
	/**
	 * 查询出所有的书籍信息
	 * @return
	 * @throws Exception
	 */
	List<Book> listAllBooks() throws Exception;
	
	/**
	 * 查询所有书籍信息的记录条数
	 * @return
	 * @throws Exception
	 */
	int getBookCount(String keyword,String Condition) throws Exception;
	int getBookCount() throws Exception;
	
	/**
	 * 通过isbn号来精确匹配一本图书
	 * @param ISBN
	 * @return
	 * @throws Exception
	 */
	Book  findByISBN(Integer ISBN) throws Exception;
	
	/**
	 * 按图书名称来模糊查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<Book> findByName(String name,int pageindex, int length) throws Exception;
	List<Book> findByName(String name) throws Exception;
	/**
	 *按类型进行查询 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<Book> findByType(String type) throws Exception;
	
	/**
	 * 书籍的分页查询
	 * @param offset
	 * @param length
	 * @return
	 * @throws Exception
	 */
	List<Book> queryForPage(int pageindex,int length) throws Exception;
	
	/**
	 * an书的id来进行精确查询
	 * @param bId
	 * @return
	 * @throws Exception
	 */
	Book findByBid(Integer bId) throws Exception;

}
