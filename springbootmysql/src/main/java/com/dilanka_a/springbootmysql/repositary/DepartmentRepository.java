package com.dilanka_a.springbootmysql.repositary;

import com.dilanka_a.springbootmysql.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
