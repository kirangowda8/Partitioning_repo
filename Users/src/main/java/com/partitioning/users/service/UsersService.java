package com.partitioning.users.service;

import java.util.List;

import com.partitioning.users.entity.Users;

public interface UsersService {
	
	Users registerUser(Users users);
	
	List<Users> getAllUsers();
	
	Users getByUserName(String name);
	
	Users updateUser(Users users,Integer userId);
	
	void deleteUsers(Integer UserId);
	
}
