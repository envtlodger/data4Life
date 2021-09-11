package com.hospital.service;

import com.hospital.model.AppointmentDTO;
import com.hospital.model.Patient;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    public Set<AppointmentDTO>  getAppointmentsByDate(String doctorId);
}
