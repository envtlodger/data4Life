package com.hospital.repository;

import com.hospital.model.Doctor;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, String> {

    @Query(value = "select * from doctor d where d.name like :name",
            nativeQuery = true)
    Optional<Doctor> findByName(@NotNull String name);

}
