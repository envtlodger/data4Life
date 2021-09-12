package com.hospital.repository;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class DoctorRepositoryTest {


    @Inject
    DoctorRepository doctorRepository;


    @Test
    void testCrudOperations() {

        Set<Appointment> appointments = new HashSet<>();

        appointments.add(new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0)));
        appointments.add(new Appointment("A2", LocalDateTime.of(2018, 04, 8, 10, 0, 0)));

        Doctor doctor = new Doctor("D1", "D1Name", appointments);

        doctorRepository.save(doctor);

        assertEquals(1, doctorRepository.count());

        Optional<Doctor> doctor1 = doctorRepository.findByName("D1Name");

        assertSame("D1Name", doctor1.get().getName());
    }
}
