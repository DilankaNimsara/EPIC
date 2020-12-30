package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItem_PK pk;

    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Items items;

}
