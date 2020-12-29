package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Orders {
    @Id
    private int oid;
    private Date date;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "cid", nullable = false)
    private Customer customer;

    public Orders(int oid, Date date, double amount, Customer customer) {
        this.oid = oid;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
    }

    public Orders() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", date=" + date +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
