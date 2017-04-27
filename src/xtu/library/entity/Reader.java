package xtu.library.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 读者实体类
 * @author zx929
 *
 */
@Entity
@Table(name = "reader")
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rId;
	
	private String rName;
	private String rPwd;
	private String rSex;
	
	private String logoSrc;
	
	//学号
	@Column(unique = true)
	private Integer rNo;
	//读者的类别编号
	private Integer rLBID;
	//读者的类型
	private Integer tType;
	//所在的院系
	private String rDept;
	//所在的专业
	private String rPref;
	//所在的年级
	private Integer rGrade;
	//创建的时间
	private Date rCreateDate;
	
	//读者借阅证,配置为与借阅证的单边一对一关系。
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = ReaderCard.class)
	@JoinColumn(name="rc_id",unique = true)
	private ReaderCard readerCard;
	
	public ReaderCard getReaderCard() {
		return readerCard;
	}
	public void setReaderCard(ReaderCard readerCard) {
		this.readerCard = readerCard;
	}
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrPwd() {
		return rPwd;
	}
	public void setrPwd(String rPwd) {
		this.rPwd = rPwd;
	}
	public String getrSex() {
		return rSex;
	}
	public void setrSex(String rSex) {
		this.rSex = rSex;
	}
	public Integer getrNo() {
		return rNo;
	}
	public void setrNo(Integer rNo) {
		this.rNo = rNo;
	}
	public Integer getrLBID() {
		return rLBID;
	}
	public void setrLBID(Integer rLBID) {
		this.rLBID = rLBID;
	}
	public Integer gettType() {
		return tType;
	}
	public void settType(Integer tType) {
		this.tType = tType;
	}
	public String getrDept() {
		return rDept;
	}
	public void setrDept(String rDept) {
		this.rDept = rDept;
	}
	public String getrPref() {
		return rPref;
	}
	public void setrPref(String rPref) {
		this.rPref = rPref;
	}
	public Integer getrGrade() {
		return rGrade;
	}
	public void setrGrade(Integer rGrade) {
		this.rGrade = rGrade;
	}
	public Date getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	
	public Reader() {
		
	}
	public Reader(Integer rId, String rName, String rSex, Integer rNo, Integer rLBID, Integer tType, String rDept,
			String rPref, Integer rGrade, Date rCreateDate) {
		this.rId = rId;
		this.rName = rName;
		this.rSex = rSex;
		this.rNo = rNo;
		this.rLBID = rLBID;
		this.tType = tType;
		this.rDept = rDept;
		this.rPref = rPref;
		this.rGrade = rGrade;
		this.rCreateDate = rCreateDate;
	}
	public String getLogoSrc() {
		return logoSrc;
	}
	public void setLogoSrc(String logoSrc) {
		this.logoSrc = logoSrc;
	}
    
	
	
	
	
	
	
}
