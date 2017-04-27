package xtu.library.web.controller;

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
import xtu.library.entity.Notice;
import xtu.library.entity.Pagination;
import xtu.library.service.notice.INoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController{
	@Autowired
	private INoticeService noticeService;
	
	@ResponseBody
	@RequestMapping("/createNotice")
	private Map<String, Object> createNotice(String content, HttpSession session) {
		boolean result = false;
		if (content != null) {
			Notice notice = new Notice();
			Administrator admin = (Administrator) session.getAttribute("admin");
			notice.setAuthor(admin.getaName());
			notice.setContent(content);
			notice.setCreateDate(new Date());
			result = noticeService.createNotice(notice);
		}
		dataMap.put("msg", result);
		return dataMap;
	}
	
	@RequestMapping("queryNoticeHistory")
	public String queryNoticeHistory(Pagination pagination,HttpSession session,Model model){
		List<Notice> noticeList = null;
		if(pagination == null){
			pagination = new Pagination();
		}
		int totle = noticeService.getNoticeCount();//记录总的记录条数
		int pageSize = 5;
		int totlePage = (int) Math.ceil((double) totle / (double) pageSize);
		pagination.setTotlePage(totlePage);
		noticeList = noticeService.queryNotices(pagination.getPageIndex(), pageSize);
		
		model.addAttribute("noticeList", noticeList);
		session.setAttribute("totlePage", pagination.getTotlePage());
		session.setAttribute("pagination", pagination);
		return "common/notices";
	}
}
