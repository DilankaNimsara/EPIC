package lk.epic.controller;

import lk.epic.dto.UserDTO;
import lk.epic.service.UserServices;
import lk.epic.util.staranded.StdRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserDTO dto) {
       userServices.saveUser(dto);
        return ResponseEntity.ok().body(new StdRespons(200, "Success", null));
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<UserDTO> allUsers = userServices.getAllUsers();
        return new ResponseEntity(new StdRespons(200, "Success", allUsers), HttpStatus.OK);
    }

}
