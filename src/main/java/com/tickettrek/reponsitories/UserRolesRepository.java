package com.tickettrek.reponsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettrek.module.RoleDetail;


@Repository
public interface UserRolesRepository extends JpaRepository<RoleDetail, Integer> {
	
}
