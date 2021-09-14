package com.hospital.repository;

import com.hospital.model.Patient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class PatientRepositoryTest {

    @Inject
    PatientRepository patientRepository;


    @Test
    void testCrudOperations() {

        patientRepository.save(new Patient("P1", "P1Name", 12, "M"));
        patientRepository.save(new Patient("P2", "P2Name", 22, "F"));
        patientRepository.save(new Patient("P3", "P3Name", 32, "M"));

        assertEquals(3, patientRepository.count());

        Optional<Patient> patient = patientRepository.findByName("P2Name");

        assertSame("P2Name", patient.get().getName());
    }
}
