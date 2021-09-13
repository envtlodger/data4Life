package com.hospital.model;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Introspected
public class AppointmentDTO {
    private String patientName;
    private String doctorName;
    private LocalDateTime localDateTime;
}
