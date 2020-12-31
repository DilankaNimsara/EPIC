package com.dilanka_a.assignment.dao;

import com.dilanka_a.assignment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users,Integer> {
}
