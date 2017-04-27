package xtu.library.web.controller.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xtu.library.entity.Book;
import xtu.library.entity.BookData;
import xtu.library.entity.BorrowMessage;
import xtu.library.entity.Reader;
import xtu.library.entity.ReaderCard;
import xtu.library.service.book.IBookService;
import xtu.library.service.borrowmsg.IBorrowMsgService;
import xtu.library.service.reader.IReaderService;
import xtu.library.web.controller.BaseController;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController{
	
	@Autowired
	private IBookService bookService;
	@Autowired
	private IBorrowMsgService borMsgService;
	@Autowired
	private IReaderService readerService;
	
	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addBook")
	public Map<String,Object> addBook(Book book){
		boolean msg = false;
		Map<String,Object> map = new HashMap<String,Object>();
		if(book != null){
		msg = bookService.addBook(book);
		map.put("msg", msg);
		}
		return map;
	}
	/**
	 * 返回所有的书籍信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listAllBooks")
	public BookData listAllBooks(){
		BookData data = new BookData();
		List<Book> bookList = bookService.listAllBooks();
		data.setData(bookList);
		return data;
	}
   
	@ResponseBody
	@RequestMapping("queryBookByCondition")
	public Map<String,Object> queryBookByCondition(String condition,String keywords){
		List<Book> bookList = new ArrayList<Book>();
		if(condition !=null&&keywords != null){
			if(condition.equals("byISBN")){
				int ISBN = Integer.valueOf(keywords);
				Book book = bookService.queryByISBN(ISBN);
				bookList.add(book);
			}else if(condition.equals("byName")){
				bookList = bookService.queryByName(keywords);
				
			}else{
				bookList = bookService.queryByType(keywords);
			}
		}
		if(bookList != null)
			dataMap.put("bookList", bookList);
		return dataMap;
	}
	
	@RequestMapping("/bookInfo")
	public String toBookInfo(Integer bId,Model model){
		if(bId != null){
			Book book = bookService.queryById(bId);
			model.addAttribute("book", book);
			return "book/bookInfo";
		}else{
			return "common/error";
		}		
	}
	
	/**
	 * 跳转到更新图书信息界面
	 * @param bId
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(Integer bId,Model model){
		if(bId != null){
			Book book = bookService.queryById(bId);
			model.addAttribute("book", book);
			return "book/updateBookInfo";
		}
		return "common/error";
	}
	
	/**
	 * 对一本书进行更新
	 * @param b
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateBook")
	public Map<String,Object> updataBook(Book b){
		boolean result = false;
		Book book = null;
		if(b!=null){
			book = bookService.queryById(b.getbId());
			book.setbNo(b.getbNo());
			book.setbISBN(b.getbISBN());
			book.setbName(b.getbName());
			book.setbAuth(b.getbAuth());
			book.setbPrice(b.getbPrice());
			book.setbPublish(b.getbPublish());
			book.setbType(b.getbType());
			book.setbTol(b.getbTol());
			book.setbCopy((b.getbTol()-book.getbCopy())+book.getbCopy());
			book.setbState(b.getbState());
			book.setbRNo(b.getbRNo());
			book.setbKeyWords(b.getbKeyWords());
			book.setbIntro(b.getbIntro());
			result = bookService.updateBook(book);
			dataMap.put("result", result);
			return dataMap;
		}
		dataMap.put("result", result);
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/deleteBookById")
	public Map<String,Object> deleteBook(Integer bId){
		Book book = null;
		boolean msg = false;
		if(bId != null){
		book = bookService.queryById(bId);
		msg = bookService.deleteBook(book);
		dataMap.clear();
		dataMap.put("msg", msg);
		return dataMap;
		}
		dataMap.put("msg", msg);
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/queryBorBook")
	public Map<String,Object> queryBorBook(Integer RNO){
		List<BorrowMessage> borMsgList = null;
		if(RNO != null){
			Reader reader = readerService.findByRNo(RNO);
			borMsgList = borMsgService.queryBorMsgByCid(reader.getReaderCard().getcId());
			dataMap.put("borMsgList", borMsgList);
		}else{
			dataMap.clear();
		}
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/returnBook")
	public Map<String,Object> returnBook(Integer mId,Integer ISBN,Integer RNO){
		Reader reader = null;
		Book book = null;
		BorrowMessage borMsg = null;
		if(ISBN != null && RNO != null){
			//定位一条借阅信息
			borMsg = borMsgService.queryBorMsgByMid(mId);
			//定位借书的用户
			reader = readerService.findByRNo(RNO);
			ReaderCard readerCard = borMsg.getrCard();
			//定位一本书
			book = bookService.queryByISBN(ISBN);
			//对借阅信息进行修改
			borMsg.setBorrowState(1);
			borMsg.setBorrowDate(new Date());
			//对书籍进行更新
			book.setbCopy(book.getbCopy()+1);
			//对借书证进行更新,可借书的数量加1
			readerCard.setMaxAvailable(readerCard.getMaxAvailable()+1);
			//进行更新操作
			bookService.updateBook(book);
			borMsgService.updataBorMsg(borMsg);
			dataMap.put("msg", true);
			return dataMap;
		}
		    dataMap.put("dataMap", false);
		return dataMap;
	}

}
