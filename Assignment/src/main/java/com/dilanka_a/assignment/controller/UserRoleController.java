package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.UserRoleDto;
import com.dilanka_a.assignment.response.stdResponses;
import com.dilanka_a.assignment.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_role")
@CrossOrigin
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity insertUserRole(@RequestBody UserRoleDto userRoleDto) {
        userRoleService.addUserRole(userRoleDto);
        return ResponseEntity.ok().body(new stdResponses(200, "success", null));
    }

    @GetMapping
    public ResponseEntity getuserRoles() {
        List<UserRoleDto> userRoles = userRoleService.getUserRoles();
        return ResponseEntity.ok().body(new stdResponses(200, "success", userRoles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserroles(@PathVariable("id") int id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }


}
