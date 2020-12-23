package com.dilanka_a.springbootmysql.repositary;

import com.dilanka_a.springbootmysql.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<product,Integer> {

    product findByName(String name);

    @Query("select p from product p where p.price >= 3500 and p.name = :name")
    Collection<product> findAllActiveProducts(String name);


}
