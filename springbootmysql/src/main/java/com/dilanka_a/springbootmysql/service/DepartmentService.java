package com.dilanka_a.springbootmysql.service;

import com.dilanka_a.springbootmysql.entity.Department;
import com.dilanka_a.springbootmysql.repositary.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id){
        return departmentRepository.findById(id).orElse(null);
    }


}
