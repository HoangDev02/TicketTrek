package com.tickettrek.services;

import java.util.List;

import com.tickettrek.module.Role;

public interface RolesService {
    Role getRolesById(Integer id);
    List<Role> getAllRoles();
    Role createURoles(Role roles);
    Role updateRoles(Integer id, Role roles);
    void deleteRoles(Integer id);
}
