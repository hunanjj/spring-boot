package com.renting.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.renting.pojo.House;

public interface IHouseService {
	
	boolean insertHouse(House house);
	
	//可根据房屋、区、街道所有条件查询
	List<Map<String,Object>> selectHouse(Map<String,Object> map);
	
	
	//删除单条信息
	boolean deleteHouseOne(Integer hid);
	
	//修改信息
	boolean updateHouse(House house);

}
