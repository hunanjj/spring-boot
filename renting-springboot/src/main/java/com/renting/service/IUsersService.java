package com.renting.service;

import java.util.List;

import com.renting.pojo.Users;

public interface IUsersService {
	
	boolean insertUsers(Users user);
	
	Users selectUser(Users user);

}
