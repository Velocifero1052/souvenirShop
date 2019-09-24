package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class SomeClass2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String someData2;

    @ManyToMany(mappedBy = "refs")
    Collection<SomeClass1> refs2;


    public void setSomeData2(String someData2) {
        this.someData2 = someData2;
    }


    public void setRefs2(Collection<SomeClass1> refs2) {
        this.refs2 = refs2;
    }
}
