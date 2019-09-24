package com.example.demo.tables;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Payment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp timestamp;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "inv_id")
    private Invoice invoice;
}
