package com.hospital.repository;

import com.hospital.model.Doctor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Optional<Doctor> findByName(@NotNull String name);

    Set<Doctor> findAll();
}
