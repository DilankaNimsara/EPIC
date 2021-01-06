package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.LoginHistoryDto;
import com.dilanka_a.assignment.response.stdResponses;
import com.dilanka_a.assignment.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/login_history")
@CrossOrigin
public class LoginHistoryController {

    private final LoginHistoryService loginHistoryService;

    @Autowired
    public LoginHistoryController(LoginHistoryService loginHistoryService) {
        this.loginHistoryService = loginHistoryService;
    }

    @PostMapping
    public ResponseEntity insertLoginHistory(@RequestBody LoginHistoryDto loginHistoryDto) {
        System.out.println(loginHistoryDto);
        loginHistoryService.insertLoginHistory(loginHistoryDto);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity selectLoginHistories(@PathVariable("id") int id) {
        List<LoginHistoryDto> loginHistories = loginHistoryService.getLoginHistoriesbyID(id);
        return ResponseEntity.ok(new stdResponses(200, "success", loginHistories));
    }

    @GetMapping("/{username}")
    public ResponseEntity selectLoginHistories(@PathVariable("username") String username) {
        List<LoginHistoryDto> loginHistories = loginHistoryService.getLoginHistories(username);
        return ResponseEntity.ok(new stdResponses(200, "success", loginHistories));
    }


}
