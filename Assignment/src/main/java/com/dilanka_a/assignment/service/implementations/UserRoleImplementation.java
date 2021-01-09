package com.dilanka_a.assignment.service.implementations;

import com.dilanka_a.assignment.dao.UserRoleDao;
import com.dilanka_a.assignment.dto.UserRoleDto;
import com.dilanka_a.assignment.model.UserRole;
import com.dilanka_a.assignment.service.UserRoleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dilanka_a
 */

@Service
public class UserRoleImplementation implements UserRoleService {

    private ModelMapper modelMapper;
    private UserRoleDao userRoleDao;

    @Autowired
    public UserRoleImplementation(ModelMapper modelMapper, UserRoleDao userRoleDao) {
        this.modelMapper = modelMapper;
        this.userRoleDao = userRoleDao;
    }

    /**
     * add user roles
     *
     * @param userRoleDto
     */
    @Override
    public void addUserRole(UserRoleDto userRoleDto) {
        userRoleDao.save(modelMapper.map(userRoleDto, UserRole.class));
    }

    /**
     * get user role list
     *
     * @return user role dto
     */
    @Override
    public List<UserRoleDto> getUserRoles() {
        List<UserRole> userRoles = userRoleDao.findAll();
        return modelMapper.map(userRoles, new TypeToken<List<UserRoleDto>>() {
        }.getType());
    }

    /**
     * delete user by id
     *
     * @param id
     */

    @Override
    public void deleteUserRole(int id) {
        userRoleDao.deleteById(id);
    }
}
