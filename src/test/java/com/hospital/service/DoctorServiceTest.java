package com.hospital.service;

import com.hospital.model.*;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@MicronautTest
public class DoctorServiceTest {

    @Inject
    DoctorService doctorService;

    @Inject
    DoctorRepository doctorRepository;

    @Inject
    PatientRepository patientRepository;

    @Inject
    AppointmentRepository appointmentRepository;

    @Test
    void getAppointmentByDoctorName() {
        List<Appointment> appointments = new ArrayList<>();

        Appointment appointment1 = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0), "D1", "P1");
        Appointment appointment2 = new Appointment("A2", LocalDateTime.of(2018, 03, 8, 10, 0, 0), "D1", "P1");

        appointments.add(appointment1);
        appointments.add(appointment2);

        Doctor doctor = new Doctor("D1", "D1Name");

        doReturn(Optional.of(doctor)).when(doctorRepository).findByName("D1Name");
        doReturn(appointments).when(appointmentRepository).findAllByDoctorId("D1");

        Set<Appointment> appointmentsOutcome = doctorService.getAppointmentsByDoctorNameAndDate(doctor.getName(), LocalDate.of(2018, 03, 8));

        Assertions.assertEquals(2,appointmentsOutcome.size());
    }


//    @Test
//    void fixAppointmentByDoctorName() {
//        Set<Appointment> appointments = new HashSet<>();
//        List<Appointment> appointmentList = new ArrayList<>();
//
//        Appointment appointment1 = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0));
//        Appointment appointment2 = new Appointment("A2", LocalDateTime.of(2018, 03, 8, 10, 0, 0));
//
//        appointments.add(appointment1);
//        appointments.add(appointment2);
//
//        appointmentList.add(appointment1);
//        appointmentList.add(appointment2);
//        Doctor doctor = new Doctor("D1", "D1Name", appointments);
//        Patient patient = new Patient(appointments, "P1", "P1Name", 12, "M");
//
//        LocalDateTime localDateTime = LocalDateTime.of(2020, 10, 9, 9, 0, 0);
//
//        doReturn(Optional.of(doctor)).when(doctorRepository).findByName("D1Name");
//        doReturn(Optional.of(patient)).when(patientRepository).findByName("P1Name");
//        doReturn(Optional.of(patient)).when(patientRepository).findByName("P1Name");
//        doReturn(appointmentList).when(appointmentRepository).listOrderByIdDesc();
//
//        ConfirmationResponseDTO confirmationResponseDTO = doctorService.fixAppointment(new AppointmentDTO(patient.getName(), doctor.getName(), localDateTime));
//
//        Assertions.assertTrue(confirmationResponseDTO.getMessage().equals("save successful: Appointment id: A3"));
//    }
//
//    @Test
//    void cancelAppointment() {
//        Set<Appointment> appointments = new HashSet<>();
//
//
//        Appointment appointment1 = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0), new Doctor("D1", "D1Name"), new Patient( "P1", "P1Name", 12, "M"));
//        Appointment appointment2 = new Appointment("A2", LocalDateTime.of(2018, 03, 8, 10, 0, 0));
//
//        appointments.add(appointment1);
//        appointments.add(appointment2);
//
//        Doctor doctor = new Doctor("D1", "D1Name", appointments);
//        Patient patient = new Patient(appointments, "P1", "P1Name", 12, "M");
//
//        LocalDateTime localDateTime = LocalDateTime.of(2018, 03, 8, 9, 0, 0);
//
//        doReturn(Optional.of(doctor)).when(doctorRepository).findByName("D1Name");
//        doReturn(Optional.of(patient)).when(patientRepository).findByName("P1Name");
//
//        ConfirmationResponseDTO confirmationResponseDTO = doctorService.cancelAppointment(new AppointmentDTO("P1Name", "D1Name", localDateTime));
//
//        Assertions.assertEquals("deleted successfully", confirmationResponseDTO.getMessage(),"delete successful");
//
//    }

    @MockBean(DoctorRepository.class)
    DoctorRepository doctorRepository() {
        return mock(DoctorRepository.class);
    }

    ;

    @MockBean(PatientRepository.class)
    PatientRepository patientRepository() {
        return mock(PatientRepository.class);
    }

    ;

    @MockBean(AppointmentRepository.class)
    AppointmentRepository appointmentRepository() {
        return mock(AppointmentRepository.class);
    }

    ;
}
