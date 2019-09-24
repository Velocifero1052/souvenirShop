package com.example.demo.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Passport{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Getter
    @Setter
    private String series;

    @Getter
    @Setter
    @OneToOne(optional = false, mappedBy = "passport")
    private Person owner;
}
