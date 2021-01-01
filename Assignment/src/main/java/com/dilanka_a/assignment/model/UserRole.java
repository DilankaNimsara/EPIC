package com.dilanka_a.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userrole")
public class UserRole {

    @Id
    @Column(name = "urid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urid;
    @Column(name = "user_role")
    private String user_role;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Users> users;

    public UserRole() {
    }

    public UserRole(int urid, String user_role) {
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
        return "UserRole{" +
                "urid=" + urid +
                ", user_role='" + user_role + '\'' +
                ", users=" + users +
                '}';
    }
}
