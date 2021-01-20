package com.dilanka_a.restwebspringboot.dto;

import com.dilanka_a.restwebspringboot.entity.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class ItemsDto {
    private int iid;
    private double price;
    private String name;
    @JsonIgnore
    private List<Orders> orders;

    public ItemsDto() {
    }

    public ItemsDto(int iid, double price, String name, List<Orders> orders) {
        this.iid = iid;
        this.price = price;
        this.name = name;
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

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ItemsDto{" +
                "iid=" + iid +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
