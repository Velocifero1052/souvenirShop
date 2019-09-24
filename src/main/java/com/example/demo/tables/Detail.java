package com.example.demo.tables;


import javax.persistence.*;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer quantity;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "ord_id")
    private Order order;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pr_id")
    private Product product;

}
