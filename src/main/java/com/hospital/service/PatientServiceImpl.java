package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Set;

@Singleton
public class PatientServiceImpl {

    @Inject
    private PatientRepository patientRepository;


//    public Set<Patient> getAppointmentsByDate(String patientName) {
//        Set<Patient> patients = patientRepository.findAll();
//        return patients;
//    }
}
