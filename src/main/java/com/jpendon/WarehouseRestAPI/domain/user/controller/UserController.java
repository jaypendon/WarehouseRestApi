package com.jpendon.WarehouseRestAPI.domain.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpendon.WarehouseRestAPI.domain.user.model.User;
import com.jpendon.WarehouseRestAPI.domain.user.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userService; 
	
	public UserController() {
		
	}
	
	@GetMapping("")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		return userService.findById(userId);
	}
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		userService.save(user);
		
		return user;
	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		userService.save(user);
		
		return user; 
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteById(userId);
		
		return "Successfully deleted id - " + userId;
	}
}
