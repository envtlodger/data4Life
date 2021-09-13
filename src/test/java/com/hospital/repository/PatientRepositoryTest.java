package com.hospital.repository;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class PatientRepositoryTest {

    @Inject
    PatientRepository patientRepository;


    @Test
    void testCrudOperations() {

//        Set<Appointment> appointments = new HashSet<>();
//
//        appointments.add(new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0)));
//        appointments.add(new Appointment("A2", LocalDateTime.of(2018, 04, 8, 10, 0, 0)));

//        patientRepository.save(new Patient(appointments,"P1", "P1Name", 12, "M"));
//        patientRepository.save(new Patient(appointments,"P2", "P2Name", 22, "F"));
//        patientRepository.save(new Patient(appointments,"P3", "P3Name", 32, "M"));

        patientRepository.save(new Patient("P1", "P1Name", 12, "M"));
        patientRepository.save(new Patient("P2", "P2Name", 22, "F"));
        patientRepository.save(new Patient("P3", "P3Name", 32, "M"));

        assertEquals(3, patientRepository.count());

        Optional<Patient> patient = patientRepository.findByName("P2Name");

        assertSame("P2Name", patient.get().getName());
    }
}
