package xtu.library.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtu.library.dao.notice.INoticeDao;
import xtu.library.entity.Notice;
@Service(value = "noticeService")
public class NoticeServiceImpl implements INoticeService{
	
	@Autowired
	private INoticeDao noticeDao;
	@Override
	public boolean createNotice(Notice notice) {
		// TODO Auto-generated method stub
		try {
			noticeDao.createNotice(notice);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Notice> queryNotices(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		List<Notice> noticeList = null;
		try {
			noticeList = noticeDao.queryNotices(pageIndex, pageSize);
			return noticeList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getNoticeCount() {
		// TODO Auto-generated method stub
		try {
			return noticeDao.getNoticeCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
