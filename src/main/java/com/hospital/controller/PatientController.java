package com.hospital.controller;

import com.hospital.model.Appointment;
import com.hospital.model.AppointmentDTO;
import com.hospital.model.Patient;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Set;

@Controller("/patient")
@Validated
public class PatientController {

    @Inject
    private PatientServiceImpl patientService;

//    @Get(value = "/{patientName}", produces = MediaType.APPLICATION_JSON)
//    public Set<Patient> getAppointments(@PathVariable String patientName) {
//        return patientService.getAppointmentsByDate(patientName);
//    }
}
