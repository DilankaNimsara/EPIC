package com.dilanka_a.restapiwithUI.service;

import com.dilanka_a.restapiwithUI.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    void insertCustomer(CustomerDto customerDto);

    List<CustomerDto> selectAllCustomers();

    void updateCustomer(CustomerDto customerDto);

    void findCustomerById(int id);

    void customerByID(int id);
}
