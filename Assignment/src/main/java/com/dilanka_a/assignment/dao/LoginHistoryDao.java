package com.dilanka_a.assignment.dao;

import com.dilanka_a.assignment.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginHistoryDao extends JpaRepository<LoginHistory, Integer> {
//
//    @Query("delete from LoginHistory lh where lh.users.id=:id ")
//    void deleteAllbyID(int id);
}
