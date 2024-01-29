package com.tickettrek.reponsitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickettrek.module.User;

public interface UserReponsitory extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String userName);
	boolean existsByUsername(String username);
}
