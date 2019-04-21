package com.renting.pojo;

import java.io.Serializable;


/**
 * 街道表
 * @author 杰
 *
 */
public class Street implements Serializable{
	
	private Integer sid;//街道ID
	private String sname;//街道名称
	private Integer sdid;//关联区域ID
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSdid() {
		return sdid;
	}
	public void setSdid(Integer sdid) {
		this.sdid = sdid;
	}
	/*@Override
	public String toString() {
		return "Street [sid=" + sid + ", sname=" + sname + ", sdid=" + sdid + "]";
	}*/

	
	
}
