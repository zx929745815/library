package xtu.library.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notice")
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nId;
	
	private String author;
	
	private Date createDate;
	
	@Column(columnDefinition = "text")
	private String content;

	public Integer getnId() {
		return nId;
	}

	public void setnId(Integer nId) {
		this.nId = nId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Notice() {
	}
	
	
	
}
