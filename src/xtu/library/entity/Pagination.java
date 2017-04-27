package xtu.library.entity;
/**
 * 用于封装分页信息的实体类
 * @author 郑旭
 * 下午5:17:01
 */
public class Pagination {
	private int pageSize;//每页的大小
	private int totleSize;//总共有多少条记录
	private int totlePage;//总共有多少页
	private int pageIndex;//当前是第几页
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotleSize() {
		return totleSize;
	}
	public void setTotleSize(int totleSize) {
		this.totleSize = totleSize;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
	

}
