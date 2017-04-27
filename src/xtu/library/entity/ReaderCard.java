package xtu.library.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 本实体类用于记录用户的借阅证，一个用户对应一个借阅证。
 * @author 郑旭
 * 下午3:51:08
 */
@Entity
@Table(name="readercard")
public class ReaderCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cId;
	
	//读者借阅证,配置为与借阅证的单边一对一关系。
	@OneToOne(mappedBy = "readerCard",cascade = CascadeType.ALL,targetEntity = Reader.class)
	private Reader reader;
	
	@Column(columnDefinition ="int default 5")
	private Integer maxAvailable = 5;
	
	//一个借阅证中的所有借阅信息，配置为借阅证和借阅信息的一对多关系
	/*@OneToMany(fetch = FetchType.EAGER,targetEntity = BorrowMessage.class,cascade = {CascadeType.ALL})
	@JoinColumns(value = {
			@JoinColumn(name = "c_id",referencedColumnName ="cId")
	})*/
	@OneToMany(mappedBy = "rCard",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<BorrowMessage> broMsgList = new ArrayList<BorrowMessage>();
    
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public ReaderCard() {
	}

	public List<BorrowMessage> getBroMsgList() {
		return broMsgList;
	}

	public void setBroMsgList(List<BorrowMessage> broMsgList) {
		this.broMsgList = broMsgList;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public int getMaxAvailable() {
		return maxAvailable;
	}

	public void setMaxAvailable(int maxAvailable) {
		this.maxAvailable = maxAvailable;
	}
	
	

}
