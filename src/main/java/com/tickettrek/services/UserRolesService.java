package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.RoleDetail;


public interface UserRolesService {
    RoleDetail getUserRolesById(Integer id);
    List<RoleDetail> getAllUserRoles();
    RoleDetail updateUserRoles(Integer id, RoleDetail userRoles);
    void deleteUserRoles(Integer id);
    RoleDetail createUserRoles(RoleDetail userRoles);
}
