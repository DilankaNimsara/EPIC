package com.dilanka_a.assignment.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "loginhistory")
public class LoginHistory {

    @Id
    @Column(name = "lhid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lhid;
    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    private Users users;

    public LoginHistory() {
    }

    public LoginHistory(int lhid, Timestamp time, Users users) {
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
        return "LoginHistory{" +
                "lhid=" + lhid +
                ", time=" + time +
                ", users=" + users +
                '}';
    }
}