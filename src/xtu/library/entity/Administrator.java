package xtu.library.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String aName;
	private String aPwd; 
	private String aSex;
	
	//管理员的权限
	private Integer aAuth;
	private String aTel;
	private String aAddr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaSex() {
		return aSex;
	}
	public void setaSex(String aSex) {
		this.aSex = aSex;
	}
	public Integer getaAuth() {
		return aAuth;
	}
	public void setaAuth(Integer aAuth) {
		this.aAuth = aAuth;
	}
	public String getaTel() {
		return aTel;
	}
	public void setaTel(String aTel) {
		this.aTel = aTel;
	}
	public String getaAddr() {
		return aAddr;
	}
	public void setaAddr(String aAddr) {
		this.aAddr = aAddr;
	}
	public Administrator() {
	}
	public String getaPwd() {
		return aPwd;
	}
	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}
	
	

}
