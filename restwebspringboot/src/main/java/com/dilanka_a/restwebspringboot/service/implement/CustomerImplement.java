package com.dilanka_a.restwebspringboot.service.implement;

import com.dilanka_a.restwebspringboot.dto.CustomerDto;
import com.dilanka_a.restwebspringboot.entity.Customer;
import com.dilanka_a.restwebspringboot.repo.CustomerRepo;
import com.dilanka_a.restwebspringboot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomerImplement implements CustomerService {

    private final ModelMapper modelMapper;
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerImplement(ModelMapper modelMapper, CustomerRepo customerRepo) {
        this.modelMapper = modelMapper;
        this.customerRepo = customerRepo;
    }

    @Override
    public void insertCustomer(CustomerDto customerDto) {
        customerRepo.save(modelMapper.map(customerDto, Customer.class));
    }

    @Override
    public Collection<CustomerDto> selectAllCustomers() {
        Collection<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CustomerDto>>() {
        }.getType());
    }

    @Override
    public void updateCustomer(CustomerDto customerDto, int id) {
        CustomerDto customerToUpdate = findCustomerById(id);
        if (customerToUpdate.getCid() == id) {
            customerRepo.save(modelMapper.map(customerDto, Customer.class));
        }
    }

    @Override
    public CustomerDto findCustomerById(int id) {
        Customer customer = customerRepo.findById(id).orElse(null);
        return modelMapper.map(customer, new TypeToken<CustomerDto>() {
        }.getType());
    }

    @Override
    public void deletecustomerByID(int id) {
        customerRepo.deleteById(id);
    }
}
