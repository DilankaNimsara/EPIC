package com.dilanka_a.assignment.service.implementations;

import com.dilanka_a.assignment.dao.LoginHistoryDao;
import com.dilanka_a.assignment.dto.LoginHistoryDto;
import com.dilanka_a.assignment.model.LoginHistory;
import com.dilanka_a.assignment.model.Users;
import com.dilanka_a.assignment.service.LoginHistoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginHistoryImpl implements LoginHistoryService {

    private final ModelMapper modelMapper;
    private final LoginHistoryDao loginHistoryDao;

    @Autowired
    public LoginHistoryImpl(ModelMapper modelMapper, LoginHistoryDao loginHistoryDao) {
        this.modelMapper = modelMapper;
        this.loginHistoryDao = loginHistoryDao;
    }

    @Override
    public void insertLoginHistory(LoginHistoryDto loginHistoryDto) {
        System.out.println(loginHistoryDto);
        loginHistoryDao.save(modelMapper.map(loginHistoryDto, LoginHistory.class));
    }

    @Override
    public List<LoginHistoryDto> getLoginHistories() {
        List<LoginHistory> loginHistories = loginHistoryDao.findAll();
        return modelMapper.map(loginHistories, new TypeToken<List<LoginHistoryDto>>() {
        }.getType());
    }

    @Override
    public void deleteLoginHistory(int id) {
//        loginHistoryDao.deleteAllbyID(id);
    }
}
