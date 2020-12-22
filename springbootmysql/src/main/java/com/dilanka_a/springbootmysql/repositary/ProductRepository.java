package com.dilanka_a.springbootmysql.repositary;

import com.dilanka_a.springbootmysql.entity.product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<product,Integer> {
    product findByName(String name);
}
