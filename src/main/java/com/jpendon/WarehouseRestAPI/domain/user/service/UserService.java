package com.jpendon.WarehouseRestAPI.domain.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpendon.WarehouseRestAPI.domain.user.model.User;
import com.jpendon.WarehouseRestAPI.domain.user.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public List<User> findAll() {

		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

	
}
