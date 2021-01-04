package com.dilanka_a.assignment.dto;

import com.dilanka_a.assignment.model.LoginHistory;
import com.dilanka_a.assignment.model.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UsersDto {
    private int id;
    private String username;
    private String password;
    @JsonIgnore
    private UserRole userRole;
    @JsonIgnore
    private List<LoginHistory> loginHistories;

    public UsersDto() {
    }

    public UsersDto(int id, String username, String password, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<LoginHistory> getLoginHistories() {
        return loginHistories;
    }

    public void setLoginHistories(List<LoginHistory> loginHistories) {
        this.loginHistories = loginHistories;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", loginHistories=" + loginHistories +
                '}';
    }
}
