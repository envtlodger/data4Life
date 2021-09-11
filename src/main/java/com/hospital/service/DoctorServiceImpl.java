package com.hospital.service;

import com.hospital.Utils;
import com.hospital.model.Appointment;
import com.hospital.model.AppointmentDTO;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repository.DoctorRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Set;

@Singleton
public class DoctorServiceImpl implements DoctorService {

    @Inject
    private DoctorRepository doctorRepository;

    @Override
    public Set<AppointmentDTO> getAppointmentsByDate(String doctorName) {
        Optional<Doctor> doctor = doctorRepository.findByName(doctorName);
        Doctor doctor1 = doctor.get();
        return Utils.appointmentDTOList(doctor1.getAppointments());
    }
}
