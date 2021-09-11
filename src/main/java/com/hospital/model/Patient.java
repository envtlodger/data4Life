package com.hospital.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {
//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {
//            CascadeType.ALL
//    },mappedBy = "patients")
//    private Set<Doctor> doctors;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<Appointment> appointments;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    private String gender;

    public Patient( String name, int age, String gender, Set<Appointment> appointments) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.appointments = appointments;
    }
}
