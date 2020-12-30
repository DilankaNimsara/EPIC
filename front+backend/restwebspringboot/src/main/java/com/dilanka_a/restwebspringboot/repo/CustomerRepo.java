package com.dilanka_a.restwebspringboot.repo;

import com.dilanka_a.restwebspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
