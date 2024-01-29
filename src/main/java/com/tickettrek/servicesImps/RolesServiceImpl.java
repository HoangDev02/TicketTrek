package com.tickettrek.servicesImps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickettrek.module.Role;
import com.tickettrek.services.RolesService;



@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	private com.tickettrek.reponsitories.RolesRepository RolesRepository;

	@Override
	public Role getRolesById(Integer id) {
		return RolesRepository.findById(id).orElse(null);
	}

	@Override
	public List<Role> getAllRoles() {
		return RolesRepository.findAll();
	}

	@Override
	public Role updateRoles(Integer id, Role Roles) {
		Role existingRoles = RolesRepository.findById(id).orElse(null);
		if (existingRoles != null) {
			// Update Roles properties here

			return RolesRepository.save(existingRoles);
		}
		return null;
	}

	@Override
	public Role createURoles(Role roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoles(Integer id) {
		// TODO Auto-generated method stub
		
	}



}
