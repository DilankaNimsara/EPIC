package com.dilanka_a.restapiwithUI.api;

import com.dilanka_a.restapiwithUI.dto.CustomerDto;
import com.dilanka_a.restapiwithUI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void insertCustomers(CustomerDto customerDto) {
        customerService.insertCustomer(customerDto);
    }

}
