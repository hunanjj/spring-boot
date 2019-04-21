package com.renting.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.renting.pojo.*;

public interface HouseMapper {
	
	int insertHouse(House house);
	//可根据房屋、区、街道所有条件查询
	List<Map<String,Object>> selectHouse(Map<String,Object> map);

	//删除单条信息
	int deleteHouseOne(@Param("hid")Integer hid);
	//修改信息
	int updateHouse(House house);

}
