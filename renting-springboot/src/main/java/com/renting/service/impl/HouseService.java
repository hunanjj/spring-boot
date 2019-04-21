package com.renting.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renting.dao.HouseMapper;
import com.renting.pojo.House;
import com.renting.service.IHouseService;

@Transactional
@Service
public class HouseService implements IHouseService {
	@Autowired(required = false)
	private HouseMapper houMap;

	@Override
	public boolean insertHouse(House house) {

		if(houMap.insertHouse(house)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> selectHouse(Map<String, Object> map) {

		return houMap.selectHouse(map);
	}


	@Override
	public boolean deleteHouseOne(Integer hid) {

		if(houMap.deleteHouseOne(hid)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateHouse(House house) {

		if(houMap.updateHouse(house)>0){
			return true;
		}
		return false;
	}

}
