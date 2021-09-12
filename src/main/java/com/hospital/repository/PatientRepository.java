package com.hospital.repository;

import com.hospital.model.Patient;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient, String> {

    @Query(value = "select * from patient d where d.name like :name",
            nativeQuery = true)
    Optional<Patient> findByName(@NotNull String name);
}
