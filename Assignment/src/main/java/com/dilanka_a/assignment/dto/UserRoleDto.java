package com.dilanka_a.assignment.dto;

import com.dilanka_a.assignment.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UserRoleDto {

    private int urid;
    private String user_role;
    @JsonIgnore
    private List<Users> users;

    public UserRoleDto() {
    }

    public UserRoleDto(int urid, String user_role) {
        this.urid = urid;
        this.user_role = user_role;
    }

    public int getUrid() {
        return urid;
    }

    public void setUrid(int urid) {
        this.urid = urid;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "urid=" + urid +
                ", user_role='" + user_role + '\'' +
                ", users=" + users +
                '}';
    }
}
