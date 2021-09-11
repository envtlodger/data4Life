package com.hospital.controller;

import com.hospital.model.Appointment;
import com.hospital.model.AppointmentDTO;
import com.hospital.model.Patient;
import com.hospital.service.DoctorService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Set;

@Controller("/doctor")
@Validated
public class DoctorController {

    @Inject
    private DoctorService doctorService;

    @Get(value = "/{doctorName}", produces = MediaType.APPLICATION_JSON)
    public Set<AppointmentDTO> getAppointments(@PathVariable String doctorName) {
        return doctorService.getAppointmentsByDate(doctorName);
    }
}
