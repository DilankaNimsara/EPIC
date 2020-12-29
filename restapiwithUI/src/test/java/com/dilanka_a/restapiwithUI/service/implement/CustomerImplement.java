package com.dilanka_a.restapiwithUI.service.implement;

import com.dilanka_a.restapiwithUI.dto.CustomerDto;
import com.dilanka_a.restapiwithUI.entity.Customer;
import com.dilanka_a.restapiwithUI.repo.CustomerRepo;
import com.dilanka_a.restapiwithUI.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImplement implements CustomerService {

    private ModelMapper modelMapper;
    private CustomerRepo customerRepo;

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
    public List<CustomerDto> selectAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {

    }

    @Override
    public void findCustomerById(int id) {

    }

    @Override
    public void customerByID(int id) {

    }
}
