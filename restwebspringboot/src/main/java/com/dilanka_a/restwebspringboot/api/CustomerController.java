package com.dilanka_a.restwebspringboot.api;

import com.dilanka_a.restwebspringboot.dto.CustomerDto;
import com.dilanka_a.restwebspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void insertCustomers(@RequestBody CustomerDto customerDto) {
        customerService.insertCustomer(customerDto);
    }

    @GetMapping
    public Collection<CustomerDto> findAllCustomers() {
        return customerService.selectAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto findCustomerByID(@PathVariable("id") int id) {
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerByID(@PathVariable("id") int id) {
        customerService.deletecustomerByID(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("id") int id) {
        customerService.updateCustomer(customerDto, id);
    }


}
