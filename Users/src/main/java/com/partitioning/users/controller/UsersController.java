package com.partitioning.users.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partitioning.users.entity.Users;
import com.partitioning.users.service.UsersService;




@RestController
@RequestMapping("/api/method")
public class UsersController {
	
   
    private final UsersService usersService;

    private UsersController(UsersService usersService) {
    	this.usersService = usersService;
    }
    
	@PostMapping("/create")
	public ResponseEntity<Users> postMethodName(@RequestBody Users user) {
		return new ResponseEntity<Users>(usersService.registerUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getAll() {
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Users> getUserById(@PathVariable String name){
		return new ResponseEntity<Users>(usersService.getByUserName(name),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Users> updateUser(@RequestParam Integer id, @RequestBody Users users) {
	   return new ResponseEntity<Users>(usersService.updateUser(users,id), HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteUser(@RequestParam Integer id){
	     usersService.deleteUsers(id);	
	}
	
}
