package xtu.library.service.notice;

import java.util.List;

import xtu.library.entity.Notice;

public interface INoticeService {
	
	boolean createNotice(Notice notice);
	
	List<Notice> queryNotices(int pageIndex,int pageSize);
	
	int getNoticeCount();

}
