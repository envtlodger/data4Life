package com.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY)
//    private Set<Patient> patients;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<Appointment> appointments;

    public Doctor(String name, Set<Appointment> appointments) {
        this.name = name;
        this.appointments = appointments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
