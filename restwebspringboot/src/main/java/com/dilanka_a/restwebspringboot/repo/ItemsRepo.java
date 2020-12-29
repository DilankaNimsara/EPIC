package com.dilanka_a.restwebspringboot.repo;

import com.dilanka_a.restwebspringboot.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items, Integer> {
}
