package com.dilanka_a.assignment.service;

import com.dilanka_a.assignment.dto.UserRoleDto;

import java.util.List;

public interface UserRoleService {

    void addUserRole(UserRoleDto userRoleDto);

    List<UserRoleDto> getUserRoles();

    void deleteUserRole(int id);
}
