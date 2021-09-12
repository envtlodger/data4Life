package com.hospital.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

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
