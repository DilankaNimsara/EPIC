package com.dilanka_a.assignment.dao;

import com.dilanka_a.assignment.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryDao extends JpaRepository<LoginHistory, Integer> {
}
