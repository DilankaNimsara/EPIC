package com.dilanka_a.assignment.service;

import com.dilanka_a.assignment.dto.UsersDto;

import java.util.List;

public interface UsersService {

    void createUser(UsersDto usersDto);

    List<UsersDto> getAllUsers();

    UsersDto getUserByID(int id);

    void deleteUserbyID(int id);

    void updateUser(UsersDto usersDto, int id);

//    UsersDto getUserByUsername(String username);

    int getcountByUsername(String uername);

    UsersDto getUserByusernameAndPassword(String username, String password);

}
