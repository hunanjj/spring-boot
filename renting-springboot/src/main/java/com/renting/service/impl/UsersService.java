package com.renting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renting.dao.UsersMapper;
import com.renting.pojo.Users;
import com.renting.service.IUsersService;

@Transactional
@Service
public class UsersService implements IUsersService {
	//每一个业务方法都要初始化
		@Autowired
		private UsersMapper useMap;
	
	@Override
	public boolean insertUsers(Users user) {
		if(useMap.insertUsers(user)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Users selectUser(Users user) {
		
		return useMap.selectUser(user);
	}

}
