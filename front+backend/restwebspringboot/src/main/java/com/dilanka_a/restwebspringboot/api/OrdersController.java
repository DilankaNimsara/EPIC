package com.dilanka_a.restwebspringboot.api;

import com.dilanka_a.restwebspringboot.dto.OrdersDto;
import com.dilanka_a.restwebspringboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    void insertOrder(@RequestBody OrdersDto ordersDto) {
        System.out.println(ordersDto);
        orderService.insertOrder(ordersDto);
    }

    @GetMapping("/{id}")
    OrdersDto getOrderByID(@PathVariable("id") int id) {
        return orderService.findOrderByID(id);
    }

    @GetMapping
    List<OrdersDto> getAllOrders() {
        System.out.println(orderService.findAllOrders());
        return orderService.findAllOrders();
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrderByID(id);
    }

    @PutMapping("/{id}")
    void updateOrder(@RequestBody OrdersDto ordersDto, @PathVariable("id") int id) {
        orderService.updateOrderById(ordersDto, id);
    }

    @GetMapping("/customer/{id}")
    List<OrdersDto> selectOrderByCustomerID(@PathVariable("id") int id) {
        return orderService.getOrderByCustomerID(id);
    }

}
