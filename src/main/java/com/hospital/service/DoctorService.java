package com.hospital.service;

import com.hospital.model.Appointment;
import com.hospital.model.AppointmentDTO;
import com.hospital.model.ConfirmationResponseDTO;

import java.time.LocalDate;
import java.util.Set;

public interface DoctorService {

    Set<Appointment> getAppointmentsByDoctorNameAndDate(String doctorId, LocalDate date);

    ConfirmationResponseDTO fixAppointment(AppointmentDTO appointmentDTO);

    ConfirmationResponseDTO cancelAppointment(AppointmentDTO appointmentDTO);

}
