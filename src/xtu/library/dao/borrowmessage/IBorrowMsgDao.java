package xtu.library.dao.borrowmessage;

import java.util.List;

import xtu.library.dao.base.IBaseDao;
import xtu.library.entity.Book;
import xtu.library.entity.BorrowMessage;

public interface IBorrowMsgDao extends IBaseDao{
	
	/**
	 * 按页来查找读者的借阅信息。
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<BorrowMessage> queryBorrowMsg(int rid,int pageIndex,int pageSize) throws Exception;
	List<BorrowMessage> queryBorrowMsg(int pageIndex,int pageSize) throws Exception;
	
	/**
	 * 得到指定读者的借阅信息的条数
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	int getMsgCount(int rId) throws Exception;
	int getMsgCount() throws Exception;
	
	/**
	 * 查询对应借书证未归还的书
	 * @param cId
	 * @return
	 */
	List<Book> queryBorBook(Integer cId) throws Exception ;
	
	/**
	 * 查询对应借书证未归还的借书信息
	 * @param cId
	 * @return
	 * @throws Exception
	 */
	List<BorrowMessage> queryBorMsgByCid(Integer cId) throws Exception;
	
	/**
	 * 根据mId来定位一条借阅信息
	 * @param mId
	 * @return
	 * @throws Exception
	 */
	BorrowMessage queryBorMsgByMid(Integer mId) throws Exception;
	
	/**
	 * 查看所有逾期的借书信息
	 * @return
	 * @throws Exception
	 */
	List<BorrowMessage> queryOverduBorMsg() throws Exception;
	
	/**
	 * 根据卡号来定位用户的逾期图书
	 * @param cId
	 * @return
	 * @throws Exception
	 */
	List<BorrowMessage> queryOverduBorMsgByCid(Integer cId) throws Exception;
	

	
}
