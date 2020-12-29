package com.dilanka_a.restwebspringboot.repo;

import com.dilanka_a.restwebspringboot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
}
