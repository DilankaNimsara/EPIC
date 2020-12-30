package com.dilanka_a.restwebspringboot.repo;

import com.dilanka_a.restwebspringboot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o where o.customer.cid=:id")
    List<Orders> findOrderByCustomerID(int id);

}
