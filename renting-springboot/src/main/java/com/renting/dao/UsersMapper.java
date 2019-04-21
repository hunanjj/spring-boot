package com.renting.dao;

import java.util.List;

import com.renting.pojo.Users;

public interface UsersMapper {
	
	int insertUsers(Users user);
	
	Users selectUser(Users user);

}
