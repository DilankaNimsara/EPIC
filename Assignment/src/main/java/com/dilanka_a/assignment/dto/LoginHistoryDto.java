
package com.dilanka_a.assignment.dto;

import com.dilanka_a.assignment.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
/**
 *
 * @author dilanka_a
 */


public class LoginHistoryDto {
    private int lhid;
    private Timestamp time;

    private Users  users;

    public LoginHistoryDto() {
    }

    public LoginHistoryDto(int lhid, Timestamp time, Users users) {
        this.lhid = lhid;
        this.time = time;
        this.users = users;
    }

    public int getLhid() {
        return lhid;
    }

    public void setLhid(int lhid) {
        this.lhid = lhid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "LoginHistoryDto{" +
                "lhid=" + lhid +
                ", time=" + time +
                ", users=" + users +
                '}';
    }
}