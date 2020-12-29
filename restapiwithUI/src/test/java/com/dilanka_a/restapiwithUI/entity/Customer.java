package com.dilanka_a.restapiwithUI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int cid;
    private String name;
    private String address;

    public Customer(int cid, String name, String address) {
        this.cid = cid;
        this.name = name;
        this.address = address;
    }

    public Customer() {
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
}
