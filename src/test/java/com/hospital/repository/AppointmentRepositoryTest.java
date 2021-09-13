package com.hospital.repository;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class AppointmentRepositoryTest {



    @Inject
    AppointmentRepository appointmentRepository;


    @Test
    void testCrudOperations() {

        Set<Appointment> appointments = new HashSet<>();

        Appointment appointment = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0), "D1", "P1");
        Appointment appointment1 = new Appointment("A2", LocalDateTime.of(2018, 04, 8, 10, 0, 0), "D1", "P1");
        Appointment appointment2 = new Appointment("A3", LocalDateTime.of(2019, 04, 8, 10, 0, 0), "D2", "P1");


        appointmentRepository.save(appointment);
        appointmentRepository.save(appointment1);
        appointmentRepository.save(appointment2);

        assertEquals(3, appointmentRepository.count());

        List<Appointment> appointmentIds = appointmentRepository.listOrderById();


        assertSame(3, appointmentIds.size());

        assertSame("A3", appointmentIds.get(appointmentIds.size()-1).getId());

        assertSame("D2", appointmentIds.get(appointmentIds.size()-1).getDoctorId());

        assertSame("P1", appointmentIds.get(appointmentIds.size()-1).getPatientId());

        List<Appointment> appointmentListForDoctors = appointmentRepository.findAllByDoctorId("D1");

        List<Appointment> appointmentListForPatients = appointmentRepository.findAllByPatientId("P1");

        List<Appointment> appointmentListForPatientsAndDoctors = appointmentRepository.findAllByDoctorIdAndPatientId("D1", "P1");

        assertSame(2, appointmentListForDoctors.size());

        assertSame(3, appointmentListForPatients.size());
        assertSame(2, appointmentListForPatientsAndDoctors.size());

    }
}
