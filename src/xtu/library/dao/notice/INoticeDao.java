package xtu.library.dao.notice;

import java.util.List;

import xtu.library.dao.base.IBaseDao;
import xtu.library.entity.Notice;

public interface INoticeDao extends IBaseDao{
	/**
	 * 创建一个通知
	 * @throws Exception
	 */
	void createNotice(Notice notice) throws Exception;
	
	/**
	 * 分页查询通知
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Notice> queryNotices(int pageIndex,int pageSize) throws Exception;
	
	int getNoticeCount() throws Exception;
	
}
