package com.hospital.service;

import com.hospital.model.Appointment;
import com.hospital.repository.AppointmentRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Set;

@Singleton
public class AppointmentServiceImpl {

    @Inject
    private AppointmentRepository appointmentRepository;


    public Set<Appointment> getAppointmentsByDate(String patientName) {
        Set<Appointment> appointments = appointmentRepository.findAll();
        return appointments;
    }
}
