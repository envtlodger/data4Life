package com.hospital.model;


import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Introspected
public class DoctorAndDateDTO {

    private String doctorName;
    private LocalDate date;
}
