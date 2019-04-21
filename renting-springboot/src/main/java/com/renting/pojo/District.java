package com.renting.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;




/**
 * 区域表
 * @author 杰
 *
 */
public class District implements Serializable {
	
	private Integer did;//区域ID
	private String dname;//区域ID
	private Set<Street> streets = new HashSet<>();//该区域下的街道
	//private Street street;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<Street> getStreets() {
		return streets;
	}
	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}
	@Override
	public String toString() {
		return "District [did=" + did + ", dname=" + dname + ", streets=" + streets + "]";
	}

	
}
