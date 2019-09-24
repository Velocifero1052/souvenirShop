package com.example.demo.tables;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Integer price;
   // private String photo;
    @OneToMany(mappedBy = "product")
    private List<Detail> details;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
