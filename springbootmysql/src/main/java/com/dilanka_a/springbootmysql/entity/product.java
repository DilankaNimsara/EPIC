package com.dilanka_a.springbootmysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")

public class product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;

    @ManyToOne
    private Department department;

}
