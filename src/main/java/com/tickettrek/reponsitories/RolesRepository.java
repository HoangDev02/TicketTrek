package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettrek.module.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);
	
}
