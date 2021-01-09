package com.dilanka_a.assignment.controller;

import com.dilanka_a.assignment.dto.LoginHistoryDto;
import com.dilanka_a.assignment.response.stdResponses;
import com.dilanka_a.assignment.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dilanka_a
 * <p>
 * Login history Controller
 */

@RestController
@RequestMapping("/api/v1/login_history")
@CrossOrigin
public class LoginHistoryController {

    private final LoginHistoryService loginHistoryService;

    @Autowired
    public LoginHistoryController(LoginHistoryService loginHistoryService) {
        this.loginHistoryService = loginHistoryService;
    }

    /**
     * post mapping (/api/v1/login_history)
     *
     * @param loginHistoryDto
     * @return
     */
    @PostMapping
    public ResponseEntity insertLoginHistory(@RequestBody LoginHistoryDto loginHistoryDto) {
        System.out.println(loginHistoryDto);
        loginHistoryService.insertLoginHistory(loginHistoryDto);
        return ResponseEntity.ok(new stdResponses(200, "success", null));
    }

    /**
     * get history by id
     * get mapping (/api/v1/login_history/id/1)
     *
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public ResponseEntity selectLoginHistories(@PathVariable("id") int id) {
        List<LoginHistoryDto> loginHistories = loginHistoryService.getLoginHistoriesbyID(id);
        return ResponseEntity.ok(new stdResponses(200, "success", loginHistories));
    }

    /**
     * get history by username
     * get maping (/api/v1/login_history/name)
     *
     * @param username
     * @return
     */

    @GetMapping("/{username}")
    public ResponseEntity selectLoginHistories(@PathVariable("username") String username) {
        List<LoginHistoryDto> loginHistories = loginHistoryService.getLoginHistories(username);
        return ResponseEntity.ok(new stdResponses(200, "success", loginHistories));
    }


}
