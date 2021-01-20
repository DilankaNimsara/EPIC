package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private int oid;
    private Date date;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "cid", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "itemsorders",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "oid"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "iid"))
    private List<Items> items;

    public Orders() {
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

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", date=" + date +
                ", amount=" + amount +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
