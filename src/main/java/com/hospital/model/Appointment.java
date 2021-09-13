package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {

    @Id
    private String id;

    private LocalDateTime localDateTime;

    private String doctorId;

    private String patientId;

    public Appointment(String id, LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        this.id = id;
    }
}
