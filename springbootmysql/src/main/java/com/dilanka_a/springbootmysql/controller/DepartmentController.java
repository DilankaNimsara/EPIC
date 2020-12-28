package com.dilanka_a.springbootmysql.controller;

import com.dilanka_a.springbootmysql.entity.Department;
import com.dilanka_a.springbootmysql.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/findAllDpartments")
    public List<Department> findAllDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/findDepartmentByID/{id}")
    public Department findDepartmentbyID(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }



}
