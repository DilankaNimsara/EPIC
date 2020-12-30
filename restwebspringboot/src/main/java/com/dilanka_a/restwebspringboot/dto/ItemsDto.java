package com.dilanka_a.restwebspringboot.dto;

import java.util.Set;

public class ItemsDto {
    private int iid;
    private double price;
    private String name;

    private Set<OrdersDto> orders;

    public ItemsDto(int iid, double price, String name, Set<OrdersDto> orders) {
        this.iid = iid;
        this.price = price;
        this.name = name;
        this.orders = orders;
    }

    //    private CustomerDto customer;
//
//    public ItemsDto(int iid, double price, String name, CustomerDto customer) {
//        this.iid = iid;
//        this.price = price;
//        this.name = name;
//        this.customer = customer;
//    }
//
//    public CustomerDto getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(CustomerDto customer) {
//        this.customer = customer;
//    }
    public ItemsDto(int iid, double price, String name) {
        this.iid = iid;
        this.price = price;
        this.name = name;
    }

    public ItemsDto() {
    }

    public Set<OrdersDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrdersDto> orders) {
        this.orders = orders;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Items{" +
                "iid=" + iid +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
