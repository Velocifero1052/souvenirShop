package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;

    private String street;

    private String building;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Collection<Person> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Person> tenants) {
        this.tenants = tenants;
    }


    @OneToMany(mappedBy = "primaryAddress", fetch = FetchType.EAGER)
    private Collection<Person> tenants;
}
