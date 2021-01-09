package com.dilanka_a.assignment.service;

import com.dilanka_a.assignment.dto.UserRoleDto;

import java.util.List;

/**
 * @author dilanka_a
 */

public interface UserRoleService {

    //    insert user roles
    void addUserRole(UserRoleDto userRoleDto);

    //    get user role list
    List<UserRoleDto> getUserRoles();

    //    delete user role by id
    void deleteUserRole(int id);
}
