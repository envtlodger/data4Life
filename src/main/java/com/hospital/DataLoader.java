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
import java.util.HashSet;
import java.util.Set;

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

        if (doctorRepository.count() == 0) {
//            Set<Patient> patients = new HashSet<>();
            Set<Appointment> appointments = new HashSet<>();

            Appointment appointment1 = appointmentRepository.save(new Appointment("time year"));
            Appointment appointment2 = appointmentRepository.save(new Appointment("Time year check"));



//                        Appointment appointment1 = appointmentRepository.save(new Appointment(LocalDateTime.of(2018, 03, 8, 9, 0, 0)));
//            Appointment appointment2 = appointmentRepository.save(new Appointment(LocalDateTime.of(2018, 04, 8, 10, 0, 0)));

            appointments.add(appointment1);
            appointments.add(appointment2);


            patientRepository.save(new Patient("P1Name", 12, "M", appointments));
            patientRepository.save(new Patient("P2Name", 22, "F", appointments));
            patientRepository.save(new Patient("P3Name", 32, "M", appointments));

//            patients.add(patient1);
//            patients.add(patient2);
//            patients.add(patient3);

//            Appointment appointment1 = appointmentRepository.save(new Appointment(LocalDateTime.of(2018, 03, 8, 9, 0, 0)));
//            Appointment appointment2 = appointmentRepository.save(new Appointment(LocalDateTime.of(2018, 04, 8, 10, 0, 0)));


            doctorRepository.save(new Doctor("D1Name", appointments));

        }

    }
}
