package com.renting.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renting.dao.HTMapper;
import com.renting.pojo.HouseType;
import com.renting.service.IHTService;

@Transactional
@Service
public class HTService implements IHTService {
	
	@Autowired
	private HTMapper htMap;

	@Override
	public List<HouseType> selectHT() {
		
		return htMap.selectHT();
	}

}
