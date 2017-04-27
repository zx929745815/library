package xtu.library.service.reader;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtu.library.dao.reader.IReaderDao;
import xtu.library.dao.readercard.IReaderCardDao;
import xtu.library.entity.Reader;
import xtu.library.entity.ReaderCard;
import xtu.library.web.util.MD5Util;

@Service(value = "readerService")
public class ReaderServiceImpl implements IReaderService{
	//注入dao
	@Autowired
	private IReaderDao readerDao;
	@Autowired
	private IReaderCardDao readerCardDao;

	/*
	 * 保存读者信息
	 */
	@Override
	public boolean register(Reader reader) {
		try {
			
			//添加创建的时间
			reader.setrCreateDate(new Date());
			ReaderCard readercard = new ReaderCard();
			reader.setReaderCard(readercard);
			reader.setrPwd(MD5Util.MD5Encrypt(reader.getrPwd()));
			readerDao.save(reader);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 管理员手动添加读者信息
	 */
	@Override
	public boolean addReader(Reader reader) {
		try {
			ReaderCard readerCard = new ReaderCard();
			//添加创建的时间
			reader.setrCreateDate(new Date());
			reader.setrPwd("666666");
			reader.setrPwd(MD5Util.MD5Encrypt(reader.getrPwd()));
			reader.setReaderCard(readerCard);
		    readerDao.save(reader);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 检查登陆
	 */
	@Override
	public List<Reader> findByName(String name) {
		List<Reader> readerList = readerDao.checkByName(name);
		return readerList;
		
	}

	/*
	 * 对读者信息进行更新
	 */
	@Override
	public void updateReader(Reader reader) {
		readerDao.updateReader(reader);
	}

	@Override
	public List<Reader> listAllReader() {
		return readerDao.listAllReader();
	}

	@Override
	public Reader findByRNo(Integer rNo) {
		Reader reader = null;
		try {
		    reader = readerDao.findByRNo(rNo);
		    return reader;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}

	@Override
	public Reader findByRId(Integer rId) {
		// TODO Auto-generated method stub
		try {
			Reader reader = readerDao.findByRid(rId);
			return reader;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过读者id来对指定的读者进行删除
	 */
	@Override
	public boolean deleteReaderById(Integer rId) {
		// TODO Auto-generated method stub
		try {
			ReaderCard readerCard = readerCardDao.getReaderCardById(rId);
			//通过借阅证来级联删除用户和借阅信息
			readerDao.delete(readerCard);
			//readerDao.delete(reader);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
