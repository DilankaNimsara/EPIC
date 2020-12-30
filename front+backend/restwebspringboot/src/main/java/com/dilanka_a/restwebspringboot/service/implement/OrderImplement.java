package com.dilanka_a.restwebspringboot.service.implement;

import com.dilanka_a.restwebspringboot.dto.OrdersDto;
import com.dilanka_a.restwebspringboot.entity.Orders;
import com.dilanka_a.restwebspringboot.repo.OrderRepo;
import com.dilanka_a.restwebspringboot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImplement implements OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepo orderRepo;

    @Autowired
    public OrderImplement(ModelMapper modelMapper, OrderRepo orderRepo) {
        this.modelMapper = modelMapper;
        this.orderRepo = orderRepo;
    }

    @Override
    public void insertOrder(OrdersDto ordersDto) {
        orderRepo.save(modelMapper.map(ordersDto, Orders.class));
    }

    @Override
    public OrdersDto findOrderByID(int id) {
        Orders orders = orderRepo.findById(id).orElse(null);
        return modelMapper.map(orders, new TypeToken<OrdersDto>() {
        }.getType());
    }

    @Override
    public List<OrdersDto> findAllOrders() {
        List<Orders> orders = orderRepo.findAll();
        return modelMapper.map(orders, new TypeToken<List<OrdersDto>>() {
        }.getType());
    }

    @Override
    public void deleteOrderByID(int id) {
        orderRepo.deleteById(id);
    }

    @Override
    public void updateOrderById(OrdersDto ordersDto, int id) {
        OrdersDto ordertoUpdate = findOrderByID(id);
        if (ordertoUpdate.getOid() == id) {
            orderRepo.save(modelMapper.map(ordersDto, Orders.class));
        }
    }

    @Override
    public List<OrdersDto> getOrderByCustomerID(int id) {
        List<Orders> orders = orderRepo.findOrderByCustomerID(id);
        System.out.println(orders);
        return modelMapper.map(orders, new TypeToken<List<OrdersDto>>() {
        }.getType());
    }
}
