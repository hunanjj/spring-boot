package com.renting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renting.dao.DisMapper;
import com.renting.pojo.District;
import com.renting.pojo.Street;
import com.renting.service.IDisService;

@Transactional
@Service
public class DisService implements IDisService {

	@Autowired
	private DisMapper disMap;

	@Override
	public List<District> selectDis() {
		return disMap.selectDis();
	}

	@Override
	public District selectDistStreet(Map<String, Object> maps) {
	
		return disMap.selectDistStreet(maps);
	}

	@Override
	public List<Street> selectStreetByDid(int did) {
		return disMap.selectStreetByDid(did);
	}

}
