package com.hospital.repository;

import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Set<Appointment> findAll();
}
