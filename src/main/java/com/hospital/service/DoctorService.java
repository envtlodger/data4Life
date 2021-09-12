package com.hospital.service;

import com.hospital.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface DoctorService {

    public  Set<Appointment> getAppointmentsByDoctorNameAndDate(String doctorId, LocalDate date);

    public ConfirmationResponseDTO fixAppointment(AppointmentDTO appointmentDTO);

    public ConfirmationResponseDTO cancelAppointment(AppointmentDTO appointmentDTO);

}
