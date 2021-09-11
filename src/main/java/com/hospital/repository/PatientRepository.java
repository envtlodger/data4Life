package com.hospital.repository;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Set<Patient> findAll();
}
