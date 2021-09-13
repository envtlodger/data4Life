package com.hospital;


import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;

/*
On application start-up, load the entities
 */
@Singleton
@Requires(notEnv = Environment.TEST)
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    @Inject
    private DoctorRepository doctorRepository;

    @Inject
    private PatientRepository patientRepository;

    @Inject
    private AppointmentRepository appointmentRepository;


    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        Appointment appointment1 = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0), "D1", "P1");
        Appointment appointment2 = new Appointment("A2", LocalDateTime.of(2018, 04, 8, 10, 0, 0), "D1", "P1");
        Appointment appointment3 = new Appointment("A3", LocalDateTime.of(2018, 03, 8, 10, 0, 0), "D1", "P2");
        Appointment appointment4 = new Appointment("A4", LocalDateTime.of(2018, 04, 8, 11, 0, 0), "D1", "P1");
        Appointment appointment5 = new Appointment("A5", LocalDateTime.of(2018, 04, 18, 8, 0, 0), "D2", "P1");
        Appointment appointment6 = new Appointment("A6", LocalDateTime.of(2018, 04, 18, 9, 0, 0), "D2", "P1");
        Appointment appointment7 = new Appointment("A7", LocalDateTime.of(2018, 03, 18, 9, 0, 0), "D2", "P3");
        Appointment appointment8 = new Appointment("A8", LocalDateTime.of(2018, 04, 18, 10, 0, 0), "D2", "P3");


        appointmentRepository.save(appointment1);
        appointmentRepository.save(appointment2);
        appointmentRepository.save(appointment3);
        appointmentRepository.save(appointment4);
        appointmentRepository.save(appointment5);
        appointmentRepository.save(appointment6);
        appointmentRepository.save(appointment7);
        appointmentRepository.save(appointment8);

        Doctor d1 = new Doctor("D1", "D1Name");
        Doctor d2 = new Doctor("D2", "D2Name");
        Doctor d3 = new Doctor("D3", "D3Name");

        doctorRepository.save(d1);
        doctorRepository.save(d2);
        doctorRepository.save(d3);

        Patient p1 = new Patient("P1", "P1Name", 12, "M");
        Patient p2 = new Patient("P2", "P2Name", 22, "F");
        Patient p3 = new Patient("P3", "P3Name", 32, "M");

        patientRepository.save(p1);
        patientRepository.save(p2);
        patientRepository.save(p3);
    }
}
