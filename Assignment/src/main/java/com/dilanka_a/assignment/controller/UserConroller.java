package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.UsersDto;
import com.dilanka_a.assignment.response.stdResponses;
import com.dilanka_a.assignment.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserConroller {

    private final UsersService usersService;

    @Autowired
    public UserConroller(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UsersDto usersDto) {
        int user = usersService.createUser(usersDto);
        if (user == 0) {
            return ResponseEntity.ok(new stdResponses(0, "already exits", null));
        } else {
            return ResponseEntity.ok(new stdResponses(200, "success", usersDto));
        }

    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<UsersDto> allUsers = usersService.getAllUsers();
        return ResponseEntity.ok(new stdResponses(200, "success", allUsers));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsersByID(@PathVariable("id") int id) {
        UsersDto userByID = usersService.getUserByID(id);
        return ResponseEntity.ok(new stdResponses(200, "success", userByID));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserByIS(@PathVariable("id") int id) {
        usersService.deleteUserbyID(id);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateByUserID(@RequestBody UsersDto usersDto, @PathVariable("id") int id) {
        usersService.updateUser(usersDto, id);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity loginValidation(@PathVariable("username") String username, @PathVariable("password") String password) {
        UsersDto usersDto = usersService.getUserByusernameAndPassword(username, password);
        return ResponseEntity.ok(new stdResponses(200, "validated", usersDto.getId()));
    }

}
