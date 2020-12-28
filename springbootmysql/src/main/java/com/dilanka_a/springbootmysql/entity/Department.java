package com.dilanka_a.springbootmysql.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DEPARTMENT_TBL")
public class Department {

    @Id
    @GeneratedValue
    private int id;

    private String name;
}
