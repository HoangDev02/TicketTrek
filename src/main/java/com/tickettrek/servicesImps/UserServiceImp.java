package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tickettrek.module.User;
import com.tickettrek.reponsitories.UserReponsitory;
import com.tickettrek.services.UserService;

public class UserServiceImp implements UserService{
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserReponsitory userReponsitory;
	
	@Override
	public User createUser(User user) {
//		String username = user.getUsername();
//		boolean exists = userReponsitory.existsByUsername(username);
//		if(exists) {
//			throw new RuntimeException("Username already exists");
//		}
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		user.setRole("USER");
//		user.setEnabled(true);
//		
//		User saveUser = userReponsitory.save(user);
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userReponsitory.findAll();
	}

	@Override
	public User getUserById(Integer user) {
		// TODO Auto-generated method stub
		return userReponsitory.findById(user).orElse(null);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userReponsitory.deleteById(id);
	}

}
