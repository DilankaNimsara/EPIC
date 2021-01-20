package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Items {
    @Id
    @GeneratedValue
    private int iid;
    private double price;
    private String name;

    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Items() {
    }

    public Items(int iid, double price, String name, List<Orders> orders) {
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
        return "Items{" +
                "iid=" + iid +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
