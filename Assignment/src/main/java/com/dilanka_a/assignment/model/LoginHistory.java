package com.dilanka_a.assignment.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loginhistory")
public class LoginHistory {

    @Id
    @GeneratedValue
    @Column(name = "lhid")
    private int lhid;
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id" , nullable = false)
    private Users users;

    public LoginHistory() {
    }

    public LoginHistory(int lhid, Date time, Users users) {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
        return "LoginHistory{" +
                "lhid=" + lhid +
                ", time=" + time +
                ", users=" + users +
                '}';
    }
}
