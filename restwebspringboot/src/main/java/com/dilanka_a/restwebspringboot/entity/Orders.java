package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    private int oid;
    @EmbeddedId
    private OrderItem_PK pk;
    private Date date;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustomerID", referencedColumnName = "cid", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "order_item", joinColumns = {
            @JoinColumn(name = "oid", referencedColumnName = "oid")
    }, inverseJoinColumns = {
            @JoinColumn(name = "iid", referencedColumnName = "iid")
    })
    private List<Items> items;

    public Orders() {

    }

    public Orders(int oid, Date date, double amount, Customer customer, Items items) {
        this.oid = oid;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
        this.pk = new OrderItem_PK(items.getIid(), oid);
    }

    public Orders(int oid, Date date, double amount, Customer customer, List<Items> items) {
        this.oid = oid;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
        this.items = items;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
