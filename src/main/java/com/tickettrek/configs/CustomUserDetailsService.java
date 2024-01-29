package com.tickettrek.configs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tickettrek.module.User;
import com.tickettrek.reponsitories.UserReponsitory;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserReponsitory userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepository.findByUsername(username);

		if (!optionalUser.isPresent()) {
			throw new UsernameNotFoundException("User not found");
		}

		User user = optionalUser.get();

		return new CustomUserDetails(user);
	}
	
	

}