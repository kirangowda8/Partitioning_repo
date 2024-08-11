package com.partitioning.users.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.partitioning.users.entity.Users;
import com.partitioning.users.entity.compositekey.UsersCompKey;
import com.partitioning.users.repository.UsersRepository;
import com.partitioning.users.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private UsersRepository usersRepository;
	
	private UsersServiceImpl(UsersRepository usersRepository) {
	    this.usersRepository=usersRepository;
	}
	
	
	@Override
	public Users registerUser(Users users) {
		Integer month = LocalDate.now().getMonthValue();
		UsersCompKey compKey = new UsersCompKey();
		compKey.setId(usersRepository.getUserId());
		compKey.setExtractMonth(month);
	    users.setUsersCompKey(compKey);
	    users.setCreationDate(LocalDate.now());
		return usersRepository.save(users);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getByUserName(String name) {
		return usersRepository.findByName(name);
	}

	@Override
	public Users updateUser(Users users, Integer userId) {
		Users user = usersRepository.findByUsersCompKeyId(userId);
		user.setName(users.getName());
		user.setCreationDate(LocalDate.now());
		user.setDOb(users.getDOb());
		user.setState(users.getState());
		user.setAge(users.getAge());
		usersRepository.save(user);
		return user;
		
		}

	@Override
	public void deleteUsers(Integer userId) {
	 Users user = usersRepository.findByUsersCompKeyId(userId);
	 usersRepository.deleteById(user.getUsersCompKey());
   	 
	}


}
