package com.hospital.repository;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class AppointmentRepositoryTest {



    @Inject
    AppointmentRepository appointmentRepository;


    @Test
    void testCrudOperations() {

        Set<Appointment> appointments = new HashSet<>();

        Appointment appointment = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0));
        Appointment appointment1 = new Appointment("A2", LocalDateTime.of(2018, 04, 8, 10, 0, 0));



        appointmentRepository.save(appointment);
        appointmentRepository.save(appointment1);

        assertEquals(2, appointmentRepository.count());

        List<Appointment> appointmentIds = appointmentRepository.listOrderByIdDesc();


        assertSame(2, appointmentIds.size());

        assertSame("A2", appointmentIds.get(0).getId());

    }
}
