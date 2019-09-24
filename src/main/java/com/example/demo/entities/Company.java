package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Person> getWorkers() {
        return workers;
    }

    public void setWorkers(Collection<Person> workers) {
        this.workers = workers;
    }

    @ManyToMany(mappedBy = "workingPlaces")
    private Collection<Person> workers;
}