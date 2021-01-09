package com.dilanka_a.assignment.service;

import com.dilanka_a.assignment.dto.UsersDto;

import java.util.List;

/**
 * @author dilanka_a
 */

public interface UsersService {
    //create new user
    int createUser(UsersDto usersDto);

    //get all users
    List<UsersDto> getAllUsers();

    //get user by id
    UsersDto getUserByID(int id);

    //delete user by id
    void deleteUserbyID(int id);

    //update user by id
    void updateUser(UsersDto usersDto, int id);

    //get count by user neme
    int getcountByUsername(String uername);

    //get user by username and password
    UsersDto getUserByusernameAndPassword(String username, String password);

}
