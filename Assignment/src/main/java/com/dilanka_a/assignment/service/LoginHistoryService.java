package com.dilanka_a.assignment.service;

import com.dilanka_a.assignment.dto.LoginHistoryDto;

import java.util.List;

/**
 * @author dilanka_a
 */

public interface LoginHistoryService {

    //    insert login history
    void insertLoginHistory(LoginHistoryDto loginHistoryDto);

    //    get login history by username
    List<LoginHistoryDto> getLoginHistories(String username);

    //    get login history by id
    List<LoginHistoryDto> getLoginHistoriesbyID(int id);
}
