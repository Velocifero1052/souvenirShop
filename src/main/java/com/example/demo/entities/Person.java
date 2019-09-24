package com.example.demo.entities;

import org.springframework.cglib.reflect.ConstructorDelegate;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;
import java.util.Collection;


@Entity
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Collection<Company> getWorkingPlaces() {
        return workingPlaces;
    }

    public void setWorkingPlaces(Collection<Company> workingPlaces) {
        this.workingPlaces = workingPlaces;
    }

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "PASSPORT_ID")
    private Passport passport;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Address primaryAddress;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_COMPANIES",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID")
    )
    private Collection<Company> workingPlaces;

}
