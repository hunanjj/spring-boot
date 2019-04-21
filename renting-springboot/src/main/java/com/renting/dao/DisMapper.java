package com.renting.dao;

import java.util.*;

import com.renting.pojo.District;
import com.renting.pojo.Street;

public interface DisMapper {
	
	List<District> selectDis();
	
	District selectDistStreet(Map<String,Object> maps);
	
	List<Street> selectStreetByDid(int did);
	

}
