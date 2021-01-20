package com.dilanka_a.restwebspringboot.dto;

import com.dilanka_a.restwebspringboot.entity.Items;

import java.util.Date;
import java.util.List;

public class OrdersDto {

    private int oid;
    private Date date;
    private double amount;
    private CustomerDto customer;
    private List<Items> items;

    public OrdersDto() {
    }

    public OrdersDto(int oid, Date date, double amount, CustomerDto customer, List<Items> items) {
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

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }


}
