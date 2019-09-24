package com.example.demo.tables;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String country;
    private String address;
    private String phone;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Order> orders;
}
