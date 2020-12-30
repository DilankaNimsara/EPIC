package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Items {
    @Id
    private int iid;
    private double price;
    private String name;

    @ManyToMany(mappedBy = "items")
    private List<Orders> orders;

    public Items() {
    }

    public Items(int iid, double price, String name) {
        this.iid = iid;
        this.price = price;
        this.name = name;
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
}
