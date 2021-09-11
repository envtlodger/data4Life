package com.hospital.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Introspected
@Setter
public class AppointmentDTO {
    private long id;
    private String localDateTime;
}
