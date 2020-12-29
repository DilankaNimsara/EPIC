package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    @Id
    private int cid;
    private String name;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> orders;
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Items> items;
//
//    public List<Items> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Items> items) {
//        this.items = items;
//    }

    public Customer(int cid, String name, String address) {
        this.cid = cid;
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
