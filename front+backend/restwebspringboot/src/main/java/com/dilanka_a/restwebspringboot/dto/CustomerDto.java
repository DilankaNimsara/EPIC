package com.dilanka_a.restwebspringboot.dto;

public class CustomerDto {
    private int cid;
    private String name;
    private String address;

    public CustomerDto(int cid, String name, String address) {
        this.cid = cid;
        this.name = name;
        this.address = address;
    }

    public CustomerDto() {
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

