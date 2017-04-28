package xtu.library.web.controller.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import xtu.library.entity.Book;
import xtu.library.entity.BorrowMessage;
import xtu.library.entity.Pagination;
import xtu.library.entity.Reader;
import xtu.library.entity.ReaderCard;
import xtu.library.entity.ReaderData;
import xtu.library.service.book.IBookService;
import xtu.library.service.borrowmsg.IBorrowMsgService;
import xtu.library.service.notice.INoticeService;
import xtu.library.service.reader.IReaderService;
import xtu.library.service.readercard.IReaderCardService;
import xtu.library.web.controller.BaseController;
import xtu.library.web.util.FileHandleUtil;
import xtu.library.web.util.StringUtil;

@Controller
@RequestMapping("/reader")
public class ReaderController extends BaseController {

	// 注入ReaderService
	@Autowired
	private IReaderService readerService;
	// 注入BookService
	@Autowired
	private IBookService bookService;
	@Autowired
	private IBorrowMsgService borMsgService;
	@Autowired
	private IReaderCardService readerCardService;

	/**
	 * 管理员首页的注意事项界面
	 * 
	 * @return
	 */
	@RequestMapping("/toAttention")
	public String toAttention() {
		return "reader/attention";
	}

	/*
	 * 查看读者信息
	 */
	@RequestMapping("/readerInfo")
	public String readerInfo(HttpSession session, Model model, Integer rId) {
		if (rId == null) {
			Reader r = (Reader) session.getAttribute("reader");
			if (r != null) {// session失效，跳转到登陆界面
				rId = r.getrId();
			} else {
				return "redirect:login/logOut.do";
			}
		}
		Reader reader = readerService.findByRId(rId);
		model.addAttribute("reader", reader);
		return "reader/readerInfo";
	}

	/*
	 * 跳转到修改读者信息界面
	 */
	@RequestMapping("/updateReaderInfo")
	public String editReaderInfo(HttpSession session, Integer rId, Model model) {
		Reader reader = null;
		// reader = (Reader) session.getAttribute("reader");
		if (reader == null) {
			reader = readerService.findByRId(rId);
		}
		model.addAttribute("reader", reader);
		return "reader/updateReaderInfo_r";
	}

	@RequestMapping("/toUpdatePassWord")
	public String toUpdatePassWord() {
		return "reader/updatePassWord";
	}

	/**
	 * 跳转到读者搜索书籍的界面
	 * 
	 * @return
	 */
	@RequestMapping("/toSearchBook")
	public String toSearchBook(Pagination pagination, Model model, HttpSession session) {
		if (pagination == null) {
			pagination = new Pagination();
		}
		List<Book> bookList = null;
		int totle = -1;// 用户记录总记录的条数
		int pageSize = 5;// 配置每一页的记录条数
		totle = bookService.getBookCount();
		int totlePage = (int) Math.ceil((double) totle / (double) pageSize);
		pagination.setTotlePage(totlePage);
		bookList = bookService.queryBookList(pagination.getPageIndex(), pageSize);

		model.addAttribute("bookList", bookList);
		session.setAttribute("totlePage", pagination.getTotlePage());
		session.setAttribute("pagination", pagination);
		return "reader/toSearchBook";
	}

	/*
	 * 对读者信息进行更新
	 */
	@ResponseBody
	@RequestMapping(value = "/updateReader")
	public Map<String, Object> updateReader(Reader r,
			@RequestParam(value = "tmpFile", required = false) MultipartFile tmpFile, HttpSession session,
			HttpServletRequest request) {
		String result = null;
		// 从session中获得当前用户的信息
	    Reader reader = (Reader) session.getAttribute("reader");
	    String logoSrc = reader.getLogoSrc();
		List<String> list = FileHandleUtil.getFilename(request);
		// 处理图片上传的逻辑
		if (tmpFile != null) {
			String savePath = "C:\\Users\\zx929\\Workspaces\\GraduationProject\\img\\library\\logo";
			String tmpFileName = tmpFile.getOriginalFilename();// 上传的文件名
			int dot = tmpFileName.lastIndexOf('.');
			String ext = "";
			if ((dot > -1) && (dot < (tmpFileName.length() - 1))) {
				ext = tmpFileName.substring(dot + 1);// 对后缀进行截取
			}
			// 其它格式的文件不进行处理
			if ("pgn".equalsIgnoreCase(ext) || "jpg".equalsIgnoreCase(ext) || "gif".equalsIgnoreCase(ext)) {
				// 对文件进行重命名
				String targetFileName = StringUtil.renameFileName(tmpFileName);
				// 创建需要被保存的新文件
				File target = new File(savePath, targetFileName);
				try {
					FileUtils.copyInputStreamToFile(tmpFile.getInputStream(), target);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logoSrc = targetFileName;
			}
		}
		// 对修改的字段进行更新
		reader.setrName(r.getrName());
		reader.setrSex(r.getrSex());
		reader.setrGrade(r.getrGrade());
		reader.setrDept(r.getrDept());
		reader.setrPref(r.getrPref());
		reader.setLogoSrc(logoSrc);
		try {
			readerService.updateReader(reader);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		dataMap.put("msg", result);
		return dataMap;
	}

	@ResponseBody
	@RequestMapping("/listAllReaders")
	public ReaderData listAllReader(Model model) {
		List<Reader> readerList = null;
		ReaderData data = new ReaderData();
		readerList = readerService.listAllReader();
		data.setData(readerList);
		model.addAttribute("readerList", readerList);
		return data;
	}

	@ResponseBody
	@RequestMapping("/addReader")
	public Map<String, Object> saveReader(Reader reader) {
		boolean msg = readerService.addReader(reader);
		dataMap.put("msg", msg);
		return dataMap;
	}

	/**
	 * 根据某个条件来更新读者信息
	 * 
	 * @param condition
	 * @return
	 */
	@RequestMapping("/updateReaderByCondition")
	public String updateReaderByAdmin(String condition, String keywords, Model model) {
		Reader reader = null;
		List<Reader> readerList = null;
		if (condition != null && condition.equals("byrno")) {
			Integer rno;
			try {
				rno = Integer.valueOf(keywords);
				reader = readerService.findByRNo(rno);
				model.addAttribute("reader", reader);
				return "reader/updateReaderInfo_r";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				return "common/error";
			}

		} else if (condition != null && condition.equals("byrname")) {
			String rname = keywords;
			readerList = readerService.findByName(rname);
			model.addAttribute("readerList", readerList);
			return "reader/readerList";
		}
		return "common/error";
	}

	@RequestMapping("/queryReaderByCondition")
	public String queryReaderByCondition(String condition, String keywords, Model model) {
		Reader reader = null;
		String errMsg = null;
		String operator = "search";
		List<Reader> readerList = new ArrayList<Reader>();
		if (condition != null && keywords != null) {
			if (condition.equals("byrno")) {
				Integer rno;
				try {
					rno = Integer.valueOf(keywords);
					reader = readerService.findByRNo(rno);
					readerList.add(reader);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					errMsg = "查询条件错误";
					model.addAttribute("errMsg", errMsg);
					return "common/error";
				}
			} else if (condition.equals("byrname")) {
				String rname = keywords;
				readerList = readerService.findByName(rname);
			}
			model.addAttribute("operator", operator);
			model.addAttribute("readerList", readerList);
			return "reader/readerList";
		} else {
			errMsg = "查询条件不正确";
			return "common/error";
		}

	}

	/**
	 * 对用户的密码进行更新
	 * 
	 * @param mpass
	 * @param newpass
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updatePassWord")
	public Map<String, Object> updatePassWord(String mpass, String newpass, HttpSession session) {
		if (mpass != null && newpass != null) {
			Reader reader = (Reader) session.getAttribute("reader");
			if (mpass.equals(reader.getrPwd())) {
				reader.setrPwd(newpass);
				readerService.updateReader(reader);
				dataMap.put("result", true);
			} else {
				dataMap.put("result", false);
			}
		} else {
			dataMap.put("result", false);
		}
		return dataMap;
	}

	/**
	 * 读者的借书动作
	 * 
	 * @param bId
	 * @param ISBN
	 * @param RNO
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/borrowBook")
	public Map<String, Object> borrowBook(Integer bId, Integer ISBN, Integer RNO, HttpSession session) {
		Book book = null;
		Reader reader = null;
		// 学号不为空就是通过管理员来借出
		if (RNO != null && ISBN != null) {
			reader = readerService.findByRNo(RNO);
			book = bookService.queryByISBN(ISBN);
		} else {
			if (bId != null) {
				reader = (Reader) session.getAttribute("reader");
				book = bookService.queryById(bId);
			} else {
				dataMap.put("msg", false);
				return dataMap;
			}
		}
		// 对书的数量和该用户的可借书数进行一个判断
		if (book.getbCopy() > 0 && reader.getReaderCard().getMaxAvailable() > 0) {
			BorrowMessage borrowMessage = new BorrowMessage();
			borrowMessage.setbId(book.getbId());
			borrowMessage.setBookISBN(book.getbISBN());
			borrowMessage.setBookName(book.getbName());
			borrowMessage.setBookPublish(book.getbPublish());
			borrowMessage.setBookPrice(book.getbPrice());
			borrowMessage.setBorrowDate(new Date());
			borrowMessage.setrNO(reader.getrNo());
			borrowMessage.setrName(reader.getrName());
			// 借阅的状态，1为已还，0为未还。
			borrowMessage.setBorrowState(0);
			ReaderCard readerCard = reader.getReaderCard();
			// 保存借阅信息
			borrowMessage.setrCard(readerCard);
			borMsgService.saveBorMsg(borrowMessage);
			// 对用户的可借书数量减去1;
			readerCard.setMaxAvailable(readerCard.getMaxAvailable() - 1);
			reader.setReaderCard(readerCard);
			readerService.updateReader(reader);
			// 对书的库存数量减去1
			book.setbCopy(book.getbCopy() - 1);
			bookService.updateBook(book);
			dataMap.put("msg", true);
			return dataMap;
		}
		dataMap.put("msg", false);
		return dataMap;
	}

	/**
	 * 查看借阅信息
	 * 
	 * @param session
	 * @param model
	 * @param rId
	 * @param history
	 * @return
	 */
	@RequestMapping("/toCheckBorMsg")
	public String toCheckBorMsg(HttpSession session, Model model, Integer rId, Boolean history) {
		List<BorrowMessage> borMsgList = null;
		ReaderCard readerCard = null;
		Reader reader = (Reader) session.getAttribute("reader");
		if (reader != null) {
			rId = reader.getrId();
			readerCard = readerCardService.getReaderCardById(rId);
		} else {
			readerCard = readerCardService.getReaderCardById(rId);
		}

		if (history != null && history) {
			borMsgList = readerCard.getBroMsgList();
		} else {
			borMsgList = borMsgService.queryBorMsgByCid(readerCard.getcId());
		}
		model.addAttribute("borMsgList", borMsgList);
		return "reader/broMsgList";

	}

	/**
	 * 查看逾期的图书
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryOverduBorMsg")
	public String queryOverduBorMsg(HttpSession session, Model model) {
		Reader reader = (Reader) session.getAttribute("reader");
		List<BorrowMessage> borMsgList = borMsgService.queryOverduBorMsgByCid(reader.getReaderCard().getcId());
		model.addAttribute("borMsgList", borMsgList);
		return "reader/readerOverduBorMsg";

	}

	/**
	 * 通过id来删除一个读者
	 * 
	 * @param rId
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteReaderById")
	public Map<String, Object> deleteReaderById(Integer rId, Model model) {
		boolean result = false;
		if (rId != null) {
			result = readerService.deleteReaderById(rId);
			dataMap.put("msg", result);
		}
		dataMap.put("msg", result);
		return dataMap;
	}
}