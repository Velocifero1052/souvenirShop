package com.example.demo.tables;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
public class Invoice {
    @Id
    private Integer id;
    private Integer amount;
    private Date issued;
    private Date due;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "ord_id")
    private Order order;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private List<Payment> payments;
}
