package com.jpendon.WarehouseRestAPI.domain.user.service;

import java.util.List;

import com.jpendon.WarehouseRestAPI.domain.user.model.User;

public interface IUserService {
	public List<User> findAll();

	public User findById(Long id);
	
	public void save(User user); 
	
	public void deleteById(Long id); 
	
	public void delete(User user);
}
