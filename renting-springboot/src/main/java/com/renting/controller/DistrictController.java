package com.renting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.renting.pojo.District;
import com.renting.pojo.Street;
import com.renting.pojo.Users;
import com.renting.service.IDisService;
import com.renting.service.IUsersService;

@RestController
public class DistrictController {
	@Autowired
	private IDisService disService;
	@Autowired
	private IUsersService usersService;
	
	@PostMapping("/district.json")
	//@ResponseBody
	public Object streets(Integer did) {
		System.out.println("根据区域找街道===========did="+did);
		
		List<Street> street = disService.selectStreetByDid(did);
		
		return street;
	}
	
	//注册用户名验证
	@PostMapping("/userCode.json")
	public int userCode( String user) {
		System.out.println("注册用户名验证=======user="+user);
		Users users=new Users();
		users.setUuser(user);
		Users selectUser = usersService.selectUser(users);
		int si=0;
		if(selectUser !=null) {
			si=1;
		}
		return si;
	}

}
