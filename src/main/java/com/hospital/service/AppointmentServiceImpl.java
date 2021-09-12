package com.hospital.service;

import com.hospital.model.Appointment;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Set;

@Singleton
public class AppointmentServiceImpl {

    @Inject
    private AppointmentRepository appointmentRepository;

    @Inject
    DoctorRepository doctorRepository;


//    public Set<Appointment> getAppointmentsByDate(String doctorName) {
//        Set<Appointment> appointments = appointmentRepository.findAll();
//        return appointments;
//    }
}
