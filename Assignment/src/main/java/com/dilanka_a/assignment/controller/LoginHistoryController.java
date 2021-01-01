package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.LoginHistoryDto;
import com.dilanka_a.assignment.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void insertLoginHistory(@RequestBody LoginHistoryDto loginHistoryDto) {
        System.out.println(loginHistoryDto);
        loginHistoryService.insertLoginHistory(loginHistoryDto);
    }

    @GetMapping
    public List<LoginHistoryDto> selectLoginHistories() {
        return loginHistoryService.getLoginHistories();
    }


}
