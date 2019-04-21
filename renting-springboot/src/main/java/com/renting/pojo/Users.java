package com.renting.pojo;

import java.util.Date;


/**
 * 对应的用户表
 * @author 杰
 *
 */
public class Users {
	
	private Integer uid; //用户ID
	private String uuser; //用户名
	private String pwd; //密码
	private String phone; //手机号
	private String uname; //姓名
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUuser() {
		return uuser;
	}
	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(Integer uid, String uuser, String pwd, String phone, String uname) {

		this.uid = uid;
		this.uuser = uuser;
		this.pwd = pwd;
		this.phone = phone;
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uuser=" + uuser + ", pwd=" + pwd + ", phone=" + phone + ", uname=" + uname
				+ "]";
	}
	
	
	

}
