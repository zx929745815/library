package xtu.library.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//图书的主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bId;
	//图书的编码，可以用编码来区别不同的图书
	private Integer bNo;
	//图书的ISBN,通样的书ISBN相同
	@Column(unique = true)
	private Integer bISBN;
	private String bName;
	private Double bPrice;
	private String bAuth;
	private String bPublish;
	//图书添加的时间
	private Date bDate;
	//图书的分类
	private String bType;
	//将书籍的简介设置为text类型
	@Column(columnDefinition = "text")
	private String bIntro;
	private String bKeyWords;
	//该书籍的总数
	private Integer bTol;
	//图书馆剩余的副本数
	private Integer bCopy;
	//该图书的可借状态
	private Integer bState;
	//图书所在的馆室号
	private String bRNo;
	

	
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public Integer getbNo() {
		return bNo;
	}
	public void setbNo(Integer bNo) {
		this.bNo = bNo;
	}
	public Integer getbISBN() {
		return bISBN;
	}
	public void setbISBN(Integer bISBN) {
		this.bISBN = bISBN;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Double getbPrice() {
		return bPrice;
	}
	public void setbPrice(Double bPrice) {
		this.bPrice = bPrice;
	}
	public String getbAuth() {
		return bAuth;
	}
	public void setbAuth(String bAuth) {
		this.bAuth = bAuth;
	}
	public String getbPublish() {
		return bPublish;
	}
	public void setbPublish(String bPublish) {
		this.bPublish = bPublish;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbType() {
		return bType;
	}
	public void setbType(String bType) {
		this.bType = bType;
	}
	public String getbIntro() {
		return bIntro;
	}
	public void setbIntro(String bIntro) {
		this.bIntro = bIntro;
	}
	public String getbKeyWords() {
		return bKeyWords;
	}
	public void setbKeyWords(String bKeyWords) {
		this.bKeyWords = bKeyWords;
	}
	public Integer getbTol() {
		return bTol;
	}
	public void setbTol(Integer bTol) {
		this.bTol = bTol;
	}
	public Integer getbCopy() {
		return bCopy;
	}
	public void setbCopy(Integer bCopy) {
		this.bCopy = bCopy;
	}
	public Integer getbState() {
		return bState;
	}
	public void setbState(Integer bState) {
		this.bState = bState;
	}
	public String getbRNo() {
		return bRNo;
	}
	public void setbRNo(String bRNo) {
		this.bRNo = bRNo;
	}
	
	public Book() {
	}
	
	public Book(Integer bId, Integer bISBN, String bName, String bPublish) {
		super();
		this.bId = bId;
		this.bISBN = bISBN;
		this.bName = bName;
		this.bPublish = bPublish;
	}
	
	
	
	

}
