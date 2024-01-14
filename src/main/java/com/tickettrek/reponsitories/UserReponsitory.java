package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.User;

public interface UserReponsitory extends JpaRepository<User, Integer>{
	boolean existsByUsername(String username);
}
