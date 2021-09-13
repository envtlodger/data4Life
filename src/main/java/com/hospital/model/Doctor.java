package com.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    @Id
    private String id;

    private String name;

//    @OneToMany( cascade = CascadeType.ALL, mappedBy = "doctor")
//    private Set<Appointment> appointments;

//    public Doctor(String name, Set<Appointment> appointments) {
//        this.name = name;
//        this.appointments = appointments;
//    }
//
//    public Doctor(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
