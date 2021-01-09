package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.UsersDto;
import com.dilanka_a.assignment.response.stdResponses;
import com.dilanka_a.assignment.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author dilanka_a
 * <p>
 * user controller
 */

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserConroller {

    private final UsersService usersService;

    @Autowired
    public UserConroller(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * create new user
     * post mapping (/api/v1/users)
     *
     * @param usersDto
     * @return response entity object with user dto
     */
    @PostMapping
    public ResponseEntity createUser(@RequestBody UsersDto usersDto) {
        int user = usersService.createUser(usersDto);
        if (user == 0) {
            return ResponseEntity.ok(new stdResponses(0, "already exits", null));
        } else {
            return ResponseEntity.ok(new stdResponses(200, "success", usersDto));
        }

    }

    /**
     * get all uers from the database
     * get mapping (/api/v1/users)
     *
     * @return
     */

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<UsersDto> allUsers = usersService.getAllUsers();
        return ResponseEntity.ok(new stdResponses(200, "success", allUsers));
    }

    /**
     * find user by id
     * get mapping (/api/v1/users/1)
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity getUsersByID(@PathVariable("id") int id) {
        UsersDto userByID = usersService.getUserByID(id);
        return ResponseEntity.ok(new stdResponses(200, "success", userByID));
    }

    /**
     * delete user by id (/api/v1/users/delete/1)
     * delete mapping
     *
     * @param id
     * @return
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserByIS(@PathVariable("id") int id) {
        usersService.deleteUserbyID(id);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }

    /**
     * update user account
     * put mapping (/api/v1/users/id)
     *
     * @param usersDto
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity updateByUserID(@RequestBody UsersDto usersDto, @PathVariable("id") int id) {
        usersService.updateUser(usersDto, id);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }

    /**
     * select user by matching username and password
     * get maping (/api/v1/users/username/password)
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/{username}/{password}")
    public ResponseEntity loginValidation(@PathVariable("username") String username, @PathVariable("password") String password) {
        UsersDto usersDto = usersService.getUserByusernameAndPassword(username, password);
        return ResponseEntity.ok(new stdResponses(200, "validated", usersDto.getId()));
    }

}
