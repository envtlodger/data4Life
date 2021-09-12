package com.hospital.repository;

import com.hospital.model.Appointment;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

    List<Appointment> listOrderByIdDesc();
}
