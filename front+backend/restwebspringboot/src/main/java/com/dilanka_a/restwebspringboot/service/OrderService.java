package com.dilanka_a.restwebspringboot.service;

import com.dilanka_a.restwebspringboot.dto.OrdersDto;

import java.util.List;

public interface OrderService {

    void insertOrder(OrdersDto ordersDto);

    OrdersDto findOrderByID(int id);

    List<OrdersDto> findAllOrders();

    void deleteOrderByID(int id);

    void updateOrderById(OrdersDto ordersDto,int id);

    List<OrdersDto> getOrderByCustomerID(int id);

}
