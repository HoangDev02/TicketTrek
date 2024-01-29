package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tickettrek.module.Role;
import com.tickettrek.module.RoleDetail;
import com.tickettrek.module.User;
import com.tickettrek.module.UserRoleId;
import com.tickettrek.reponsitories.RolesRepository;
import com.tickettrek.reponsitories.UserReponsitory;
import com.tickettrek.services.UserRolesService;
import com.tickettrek.services.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserReponsitory userReponsitory;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private UserRolesService userRolesService;

	@Override
	public User createUser(User user) {
		String username = user.getUsername();
		boolean exists = userReponsitory.existsByUsername(username);
		if (exists) {
			throw new RuntimeException("Username already exists");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		user.setEnabled(true);

		User saveUser = userReponsitory.save(user);
		RoleDetail roleDetail = new RoleDetail();
		UserRoleId userRoleId = new UserRoleId();
		userRoleId.setUserId(saveUser.getId());

		Role role = rolesRepository.findByName("USER");
		userRoleId.setRoleId(role.getId());
		roleDetail.setId(userRoleId);
		roleDetail.setUser(saveUser);
		roleDetail.setRole(role);
		userRolesService.createUserRoles(roleDetail);
		return saveUser;
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

	@Override
	public int getIdUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userReponsitory.findByUsername(username).get().getId();
	}

}
