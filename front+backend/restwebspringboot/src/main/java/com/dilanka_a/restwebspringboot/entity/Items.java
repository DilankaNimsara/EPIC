package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Items {
    @Id
    private int iid;
    private double price;
    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "customerid", nullable = false, referencedColumnName = "cid")
//    private Customer customer;
//
//    public Items(int iid, double price, String name, Customer customer) {
//        this.iid = iid;
//        this.price = price;
//        this.name = name;
//        this.customer = customer;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

        public Items(int iid, double price, String name) {
        this.iid = iid;
        this.price = price;
        this.name = name;
    }

    public Items() {
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
