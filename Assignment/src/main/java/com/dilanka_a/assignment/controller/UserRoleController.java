package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.UserRoleDto;
import com.dilanka_a.assignment.response.stdResponses;
import com.dilanka_a.assignment.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dilanka_a
 * <p>
 * user role controller
 */

@RestController
@RequestMapping("/api/v1/user_role")
@CrossOrigin
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    /**
     * add user role to database
     * post mapping (/api/v1/user_role)
     *
     * @param userRoleDto
     * @return
     */
    @PostMapping
    public ResponseEntity insertUserRole(@RequestBody UserRoleDto userRoleDto) {
        userRoleService.addUserRole(userRoleDto);
        return ResponseEntity.ok().body(new stdResponses(200, "success", null));
    }

    /**
     * get user role list
     * get mapping (/api/v1/user_role)
     *
     * @return
     */
    @GetMapping
    public ResponseEntity getuserRoles() {
        List<UserRoleDto> userRoles = userRoleService.getUserRoles();
        return ResponseEntity.ok().body(new stdResponses(200, "success", userRoles));
    }

    /**
     * delete user role
     * delete mapping (/api/v1/user_role/id)
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserroles(@PathVariable("id") int id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }


}
