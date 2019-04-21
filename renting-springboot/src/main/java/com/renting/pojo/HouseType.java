package com.renting.pojo;

import java.io.Serializable;



/**
 * 房屋类型表
 * @author 杰
 *
 */
public class HouseType implements Serializable {
	
	private Integer htid;
	
	private String htname;

	public Integer getHtid() {
		return htid;
	}

	public void setHtid(Integer htid) {
		this.htid = htid;
	}

	public String getHtname() {
		return htname;
	}

	public void setHtname(String htname) {
		this.htname = htname;
	}

	@Override
	public String toString() {
		return "HouseType [htid=" + htid + ", htname=" + htname + "]";
	}

	
	
	
}
