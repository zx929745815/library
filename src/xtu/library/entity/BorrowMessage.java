package xtu.library.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 本实体类用于记录用户的借阅信息，
 * @author 郑旭
 * 下午3:59:57
 */

@Entity
@Table(name = "borrowmessage")
@org.hibernate.annotations.Proxy(lazy = false)
public class BorrowMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mId;
	private Integer bId;
    private Integer bookISBN;
	private String bookName;
	private String bookPublish;
	private Double bookPrice;
	private Integer rNO;
	private String rName;
	
	private Date borrowDate;
	
	//该条记录产生的扣费信息
	private Double fine;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "c_id")
	private ReaderCard rCard;
	
	//用于记录该借阅信息的状态；
	private Integer borrowState;
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public Integer getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(Integer bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Integer getBorrowState() {
		return borrowState;
	}
	public void setBorrowState(Integer borrowState) {
		this.borrowState = borrowState;
	}
	public BorrowMessage() {
	}
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public ReaderCard getrCard() {
		return rCard;
	}
	public void setrCard(ReaderCard rCard) {
		this.rCard = rCard;
	}
	public BorrowMessage(Integer mId, Integer bId, Integer bookISBN, String bookName, 
			Double bookPrice,String bookPublish, Date borrowDate, Integer borrowState) {
		super();
		this.mId = mId;
		this.bId = bId;
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookPublish = bookPublish;
		this.bookPrice = bookPrice;
		this.borrowDate = borrowDate;
		this.borrowState = borrowState;
	}
	public Integer getrNO() {
		return rNO;
	}
	public void setrNO(Integer rNO) {
		this.rNO = rNO;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	
	
	

}
