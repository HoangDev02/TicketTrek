package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.RoleDetail;
import com.tickettrek.services.UserRolesService;



@Service
public class UserRolesServiceImpl implements UserRolesService {
	@Autowired
	private com.tickettrek.reponsitories.UserRolesRepository UserRolesRepository;

	@Override
	public	RoleDetail getUserRolesById(Integer id) {
		return UserRolesRepository.findById(id).orElse(null);
	}

	@Override
	public List<RoleDetail> getAllUserRoles() {
		return UserRolesRepository.findAll();
	}

	@Override
	public RoleDetail updateUserRoles(Integer id, RoleDetail UserRoles) {
		RoleDetail existingUserRoles = UserRolesRepository.findById(id).orElse(null);
		if (existingUserRoles != null) {
			// Update UserRoles properties here

			return UserRolesRepository.save(existingUserRoles);
		}
		return null;
	}

	@Override  
	public RoleDetail createUserRoles(RoleDetail userRoles) {
	  return UserRolesRepository.save(userRoles);
	}

	@Override
	public void deleteUserRoles(Integer id) {
		// TODO Auto-generated method stub

	}


}
