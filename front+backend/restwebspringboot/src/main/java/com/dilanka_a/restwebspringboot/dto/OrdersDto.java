package com.dilanka_a.restwebspringboot.dto;

import java.util.Date;

public class OrdersDto {

    private int oid;
    private Date date;
    private double amount;
    private CustomerDto customer;

    public OrdersDto(int oid, Date date, double amount, CustomerDto customer) {
        this.oid = oid;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
    }

    public OrdersDto() {
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
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
        return "OrdersDto{" +
                "oid=" + oid +
                ", date=" + date +
                ", amount=" + amount +
                ", customerDto=" + customer +
                '}';
    }
}
