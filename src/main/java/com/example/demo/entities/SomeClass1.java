package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class SomeClass1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String someData;


    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    public Collection<SomeClass2> getRefs() {
        return refs;
    }

    public void setRefs(Collection<SomeClass2> refs) {
        this.refs = refs;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "some_references", joinColumns = @JoinColumn(name = "SOMECLASS1_ID"), inverseJoinColumns = @JoinColumn(name = "SOMECLASS2_ID"))
    private Collection<SomeClass2> refs;
}
