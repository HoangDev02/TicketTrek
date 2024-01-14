package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.User;

public interface UserService {
	User createUser(User user);
	List<User> getAllUser();
	User getUserById(Integer user);
	void deleteUser(Integer id);
}
