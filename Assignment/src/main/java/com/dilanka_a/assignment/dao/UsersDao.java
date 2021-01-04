package com.dilanka_a.assignment.dao;

import com.dilanka_a.assignment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersDao extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.username=:username")
    Users getUserByUsername(String username);

    @Query("select count(u.username) from Users u where u.username=:username")
    int getcountByUsername(String username);

    @Query("select u from Users u where u.username=:username and u.password=:password")
    Users getUserByusernameAndPassword(String username, String password);

    @Query("select u.id,u.username,u.userRole from Users u")
    List<Users> findAllusers();
}
