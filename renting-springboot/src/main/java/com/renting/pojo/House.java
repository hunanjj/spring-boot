package com.renting.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * 对应房屋信息表
 * @author 杰
 *
 */


public class House {
	
	private Integer hid; //房屋ID
	private String htitle; //标题
	private Integer addressid; //关联地址id
	private Integer houseTypeId; //房屋类型ID
	private String area;  //面积
	private String price; //价格
	@DateTimeFormat(pattern="yyyy-MM-dd")
	/*@JSONField(format="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")*/
	private Date houseDate; //房产证日期
	private String tel; //联系方式
	private String hcontent; //详细内容
	private Date  creatDate; //发布时间
	private Integer ownerid; //主人id
	
	
	
	public Date getHouseDate() {
		return houseDate;
	}
	public void setHouseDate(Date houseDate) {
		this.houseDate = houseDate;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHtitle() {
		return htitle;
	}
	public void setHtitle(String htitle) {
		this.htitle = htitle;
	}
	public Integer getAddressid() {
		return addressid;
	}
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	public Integer getHouseTypeId() {
		return houseTypeId;
	}
	public void setHouseTypeId(Integer houseTypeId) {
		this.houseTypeId = houseTypeId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHcontent() {
		return hcontent;
	}
	public void setHcontent(String hcontent) {
		this.hcontent = hcontent;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public Integer getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}
	public House() {
		// TODO Auto-generated constructor stub
	}
	
	public House(Integer hid, String htitle, Integer addressid, Integer houseTypeId, String area, String price,
			Date houseDate, String tel, String hcontent, Date creatDate, Integer ownerid) {
		super();
		this.hid = hid;
		this.htitle = htitle;
		this.addressid = addressid;
		this.houseTypeId = houseTypeId;
		this.area = area;
		this.price = price;
		this.houseDate = houseDate;
		this.tel = tel;
		this.hcontent = hcontent;
		this.creatDate = creatDate;
		this.ownerid = ownerid;
	}
	@Override
	public String toString() {
		return "House [hid=" + hid + ", htitle=" + htitle + ", addressid=" + addressid + ", houseTypeId=" + houseTypeId
				+ ", area=" + area + ", price=" + price + ", tel=" + tel + ", hcontent=" + hcontent + ", creatDate="
				+ creatDate + ", ownerid=" + ownerid + "]";
	}
	

	
}
