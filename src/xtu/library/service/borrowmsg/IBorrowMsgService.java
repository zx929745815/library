package xtu.library.service.borrowmsg;

import java.util.List;

import xtu.library.entity.Book;
import xtu.library.entity.BorrowMessage;

public interface IBorrowMsgService {
	
	/**
	 * 分页查询借阅信息
	 * @param rId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<BorrowMessage> queryBorrowMsg(int rId,int pageIndex,int pageSize);
	List<BorrowMessage> queryBorrowMsg(int pageIndex,int pageSize);
	
	/**
	 * 得到借阅信息的条数
	 * @param rId
	 * @return
	 */
	int getBroMsgCount(int rId);
	int getBroMsgCount();
	
	/**
	 * 保存一条借阅信息
	 * @param borrowmessage
	 * @return
	 */
	boolean saveBorMsg(BorrowMessage borrowmessage);
	/**
	 * 通过cId来定位该借书证中借未归还的图书
	 * @param cId
	 * @return
	 */
	List<Book> queryBorBook(Integer cId);
	
	/**
	 * 通过cId来定位该借书证中还未归还的借书信息
	 * @param cId
	 * @return
	 */
	List<BorrowMessage> queryBorMsgByCid(Integer cId);
	
	/**
	 * 通过mId来定位一条借阅信息
	 * @param mId
	 * @return
	 */
	BorrowMessage queryBorMsgByMid(Integer mId);
	
	/**
	 * 对一条借阅信息进行更新
	 * @param borMsg
	 * @return
	 */
	boolean updataBorMsg(BorrowMessage borMsg);
	
	/**
	 * 查询逾期的借书信息
	 * @return
	 */
	List<BorrowMessage> queryOverduBorMsg();
	
	/**
	 * 根据卡号查询逾期的借书信息
	 * @return
	 */
	List<BorrowMessage> queryOverduBorMsgByCid(Integer cId);
	
}
