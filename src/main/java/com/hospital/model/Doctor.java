package com.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Patient> patients;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "doctor")
    private Set<Appointment> appointments;


    public Doctor(String name, Set<Appointment> appointments) {
        this.name = name;
        this.appointments = appointments;
    }

}
