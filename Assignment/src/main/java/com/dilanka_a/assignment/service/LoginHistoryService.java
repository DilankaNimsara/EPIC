package com.dilanka_a.assignment.service;

import com.dilanka_a.assignment.dto.LoginHistoryDto;

import java.util.List;

public interface LoginHistoryService {

    void insertLoginHistory(LoginHistoryDto loginHistoryDto);

    List<LoginHistoryDto> getLoginHistories();

    void deleteLoginHistory(int id);

}
