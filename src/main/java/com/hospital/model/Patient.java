package com.hospital.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {
//            CascadeType.ALL
//    },mappedBy = "patients")
//    private Set<Doctor> doctors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<Appointment> appointments;


    @Id
    private String id;

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
