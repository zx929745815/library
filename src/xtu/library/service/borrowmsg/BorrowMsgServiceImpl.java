package xtu.library.service.borrowmsg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtu.library.dao.borrowmessage.IBorrowMsgDao;
import xtu.library.entity.Book;
import xtu.library.entity.BorrowMessage;
import xtu.library.web.util.DateUtil;

@Service(value = "borMsgService")
public class BorrowMsgServiceImpl implements IBorrowMsgService{
	@Autowired
	private IBorrowMsgDao borMsgDao;

	public IBorrowMsgDao getBorMsgDao() {
		return borMsgDao;
	}

	public void setBorMsgDao(IBorrowMsgDao borMsgDao) {
		this.borMsgDao = borMsgDao;
	}

	@Override
	public List<BorrowMessage> queryBorrowMsg(int rId, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgList = new ArrayList<BorrowMessage>();
		try {
			borMsgList = borMsgDao.queryBorrowMsg(rId, pageIndex, pageSize);
			return borMsgList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getBroMsgCount(int rId) {
		// TODO Auto-generated method stub
		try {
			return borMsgDao.getMsgCount(rId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	@Override
	public int getBroMsgCount() {
		
		try {
			return borMsgDao.getMsgCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean saveBorMsg(BorrowMessage borrowmessage) {
		// TODO Auto-generated method stub
		try {
			borMsgDao.save(borrowmessage);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BorrowMessage> queryBorrowMsg(int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgList = null;
		try {
			borMsgList =borMsgDao.queryBorrowMsg(pageIndex,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borMsgList;
	}

	@Override
	public List<Book> queryBorBook(Integer cId) {
		// TODO Auto-generated method stub
		List<Book> bookList = null;
		try {
			bookList = borMsgDao.queryBorBook(cId);
			return bookList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BorrowMessage> queryBorMsgByCid(Integer cId) {
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgkList = null;
		try {
			borMsgkList = borMsgDao.queryBorMsgByCid(cId);
			return borMsgkList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BorrowMessage queryBorMsgByMid(Integer mId) {
		// TODO Auto-generated method stub
		BorrowMessage borMsg = null;
		try {
			borMsg = borMsgDao.queryBorMsgByMid(mId);
			return borMsg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updataBorMsg(BorrowMessage borMsg) {
		// TODO Auto-generated method stub
		try {
			borMsgDao.update(borMsg);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BorrowMessage> queryOverduBorMsg() {
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgList = null;
		try {
			
			borMsgList = borMsgDao.queryOverduBorMsg();
			for(int i = 0; i<borMsgList.size();i++){
				borMsgList.get(i).setrCard(null);
			}
			return borMsgList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BorrowMessage> queryOverduBorMsgByCid(Integer cId) {
		// TODO Auto-generated method stub
		List<BorrowMessage> borMsgList = null;
		try {
			
			borMsgList = borMsgDao.queryOverduBorMsgByCid(cId);
			for(int i = 0; i<borMsgList.size();i++){
				BorrowMessage borMsg = borMsgList.get(i);
				borMsg.setrCard(null);
				Date now = new Date();
				Date borDate = borMsg.getBorrowDate();
				int days = DateUtil.daysBetween(borDate,now);
				double fine = days*0.1;
				borMsg.setFine(fine);
			}
			return borMsgList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
