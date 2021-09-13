package com.hospital.repository;

import com.hospital.model.Appointment;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

    List<Appointment> listOrderByIdDesc();

    @Query(value = "select * from appointment a where a.doctor_Id like :doctorId",
            nativeQuery = true)
    List<Appointment> findAllByDoctorId(String doctorId);


    @Query(value = "select * from appointment a where a.patient_Id like :patientId",
            nativeQuery = true)
    List<Appointment> findAllByPatientId(String patientId);

    @Query(value = "select * from appointment a where a.patient_Id like :patientId and a.doctor_id like :doctorId",
            nativeQuery = true)
    List<Appointment> findAllByDoctorIdAndPatientId(String doctorId, String patientId);

}
