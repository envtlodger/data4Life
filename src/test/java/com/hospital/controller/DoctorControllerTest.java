package com.hospital.controller;

import com.hospital.model.*;
import com.hospital.service.DoctorService;
import com.hospital.service.DoctorServiceImpl;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class DoctorControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    DoctorService doctorService;

    @Test
    void testGetAppointments() {
        Set<Appointment> appointments = new HashSet<>();

        Appointment appointment = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0));
        Appointment appointment2 = new Appointment("A2", LocalDateTime.of(2018, 03, 8, 9, 0, 0));

        appointments.add(appointment);
        appointments.add(appointment2);

        Doctor doctor = new Doctor("D1", "D1Name");

        DoctorAndDateDTO doctorAndDateDTO = new DoctorAndDateDTO(doctor.getName(), LocalDate.of(2018, 03, 8));

        when(doctorService.getAppointmentsByDoctorNameAndDate(doctor.getName(), LocalDate.of(2018, 03, 8))).thenReturn(appointments);
        HttpResponse<Appointment[]> response = client.toBlocking().exchange(HttpRequest.POST("/doctor/get-appointments", doctorAndDateDTO), Appointment[].class);
        Assertions.assertEquals(appointments.size(), response.body().length);
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    @Test
    void testFixAppointment() {

        AppointmentDTO appointmentDTO = new AppointmentDTO("P1Name", "D1Name", LocalDateTime.of(2021, 03, 8, 9, 0, 0));

        ConfirmationResponseDTO confirmationResponseDTO = new ConfirmationResponseDTO("save successful");

        when(doctorService.fixAppointment(appointmentDTO)).thenReturn(confirmationResponseDTO);

        HttpResponse<ConfirmationResponseDTO> response = client.toBlocking().exchange(HttpRequest.PUT("/doctor/fix-appointments", appointmentDTO), ConfirmationResponseDTO.class);
        Assertions.assertEquals(confirmationResponseDTO.getMessage(), response.body().getMessage());
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    @Test
    void cancelAppointment() {

        AppointmentDTO appointmentDTO = new AppointmentDTO("P1Name", "D1Name", LocalDateTime.of(2018, 03, 8, 9, 0, 0));

        ConfirmationResponseDTO confirmationResponseDTO = new ConfirmationResponseDTO("deleted successfully");

        when(doctorService.cancelAppointment(appointmentDTO)).thenReturn(confirmationResponseDTO);

        HttpResponse<ConfirmationResponseDTO> response = client.toBlocking().exchange(HttpRequest.PUT("/doctor/cancel-appointments", appointmentDTO), ConfirmationResponseDTO.class);
        Assertions.assertEquals(confirmationResponseDTO.getMessage(), response.body().getMessage());
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }


    @MockBean(DoctorServiceImpl.class)
    DoctorService doctorService() {
        return mock(DoctorService.class);
    }
}
