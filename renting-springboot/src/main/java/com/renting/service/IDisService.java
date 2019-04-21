package com.renting.service;

import java.util.List;
import java.util.Map;

import com.renting.pojo.District;
import com.renting.pojo.Street;

public interface IDisService {

	List<District> selectDis();
	
	District selectDistStreet(Map<String,Object> maps);
	
	List<Street> selectStreetByDid(int did);
	

}
