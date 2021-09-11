package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String localDateTime;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    public Appointment(String localDateTime) {
        this.localDateTime = localDateTime;
    }
}
