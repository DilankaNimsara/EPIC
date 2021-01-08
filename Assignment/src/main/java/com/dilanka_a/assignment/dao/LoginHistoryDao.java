package com.dilanka_a.assignment.dao;

import com.dilanka_a.assignment.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginHistoryDao extends JpaRepository<LoginHistory, Integer> {

    @Query("select h from LoginHistory h where h.users.username=:username order by h.time DESC ")
    List<LoginHistory> findAllusername(String username);


    @Query("select lh from LoginHistory  lh where lh.users.id=:id order by lh.time DESC ")
    List<LoginHistory> findAllByuserId(int id);
}
