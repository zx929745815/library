package xtu.library.web.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xtu.library.entity.Administrator;
import xtu.library.entity.BorMsgData;
import xtu.library.entity.BorrowMessage;
import xtu.library.entity.Notice;
import xtu.library.entity.Pagination;
import xtu.library.service.borrowmsg.IBorrowMsgService;
import xtu.library.service.notice.INoticeService;
import xtu.library.web.controller.BaseController;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	private IBorrowMsgService borMsgService;

	/**
	 * 管理员首页的注意事项界面
	 * 
	 * @return
	 */
	@RequestMapping("/toAttention")
	public String toAttention() {
		return "admin/attention";
	}

	/*********************** 图书管理部分 *****************/
	/**
	 * 跳转到添加图书的页面
	 * 
	 * @return
	 */
	@RequestMapping("/toAddBook")
	public String toAddBook() {
		return "admin/addBook";
	}

	/**
	 * 从管理员的首页跳转到显示所有的书籍
	 * 
	 * @return
	 */
	@RequestMapping("toListAllBooks")
	public String toListAllBooks() {
		return "admin/listBooks";
	}

	/********************** 读者管理部分 ******************/
	/**
	 * 跳转到查看所有读者信息的界面
	 * 
	 * @return
	 */
	@RequestMapping("/toListAllReaders")
	public String toListAllReaders() {
		return "admin/listReaders";
	}

	/**
	 * 跳转到管理员增加用户的界面
	 * 
	 * @return
	 */
	@RequestMapping("/toAddReader")
	public String toAddReader() {
		return "admin/addReader";
	}

	/**
	 * 更新读者信息
	 * 
	 * @return
	 */
	@RequestMapping("/toUpdateReader")
	public String toUpdateReader() {
		return "admin/toUpdateReader";
	}

	/********************** 借阅信息管理部分 ******************/

	@RequestMapping("/toCheckBorMsg")
	public String toCheckBorMsg(Pagination pagination, Model model, HttpSession session) {

		if (pagination == null) {
			pagination = new Pagination();
		}
		List<BorrowMessage> borMsgList = null;
		int totle = -1;// 用户记录总记录的条数
		int pageSize = 10;// 配置每一页的记录条数
		totle = borMsgService.getBroMsgCount();
		int totlePage = (int) Math.ceil((double) totle / (double) pageSize);
		pagination.setTotlePage(totlePage);
		borMsgList = borMsgService.queryBorrowMsg(pagination.getPageIndex(), pageSize);

		model.addAttribute("borMsgList", borMsgList);
		session.setAttribute("totlePage", pagination.getTotlePage());
		session.setAttribute("pagination", pagination);

		return "admin/listBorMsgs";
	}

	@RequestMapping("/toQueryOverduBorMsg")
	public String toQueryOverduBorMsg() {
		return "admin/listOverduBorMsg";
	}

	@ResponseBody
	@RequestMapping("/queryOverduBorMsg")
	public BorMsgData queryOverduBorMsg() {
		List<BorrowMessage> borMsgList = null;
		borMsgList = borMsgService.queryOverduBorMsg();
		BorMsgData data = new BorMsgData();
		data.setData(borMsgList);
		return data;
	}

	/**
	 * 跳转到管理员还书的界面
	 * 
	 * @return
	 */
	@RequestMapping("toBorrowBook")
	public String toBorrowBook() {
		return "admin/toBorrowBook";
	}

	@RequestMapping("/toReturnBook")
	public String toReturnBook() {
		return "admin/toReturnBook";
	}

	/*************** 通知管理部分 ****************/
	@RequestMapping("/toCreateNotice")
	private String toCreateNotice() {
		return "admin/toCreateNotice";
	}

	
}
