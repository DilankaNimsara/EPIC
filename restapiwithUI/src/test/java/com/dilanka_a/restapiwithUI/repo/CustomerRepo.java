package com.dilanka_a.restapiwithUI.repo;

import com.dilanka_a.restapiwithUI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
