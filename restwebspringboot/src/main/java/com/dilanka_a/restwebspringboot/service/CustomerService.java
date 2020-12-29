package com.dilanka_a.restwebspringboot.service;

import com.dilanka_a.restwebspringboot.dto.CustomerDto;

import java.util.Collection;
import java.util.List;

public interface CustomerService {

    void insertCustomer(CustomerDto customerDto);

    Collection<CustomerDto> selectAllCustomers();

    void updateCustomer(CustomerDto customerDto,int id);

    CustomerDto findCustomerById(int id);

    void deletecustomerByID(int id);
}
