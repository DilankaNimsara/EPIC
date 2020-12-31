package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.UsersDto;
import com.dilanka_a.assignment.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserConroller {

    private UsersService usersService;

    @Autowired
    public UserConroller(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public void createUser(@RequestBody UsersDto usersDto) {
        usersService.createUser(usersDto);
    }

    @GetMapping("/get")
    public List<UsersDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto getUsersByID(@PathVariable("id") int id) {
        return usersService.getUserByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserByIS(@PathVariable("id") int id) {
        usersService.deleteUserbyID(id);
    }

    @PutMapping("/{id}")
    public void updateByUserID(@RequestBody UsersDto usersDto, int id) {
        usersService.updateUser(usersDto, id);
    }

}
