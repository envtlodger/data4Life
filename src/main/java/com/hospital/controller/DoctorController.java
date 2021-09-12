package com.hospital.controller;

import com.hospital.model.Appointment;
import com.hospital.model.AppointmentDTO;
import com.hospital.model.ConfirmationResponseDTO;
import com.hospital.model.DoctorAndDateDTO;
import com.hospital.service.DoctorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import java.util.Set;

@Controller("/doctor")
@Validated
public class DoctorController {

    @Inject
    private DoctorService doctorService;

    @Post(value = "/get-appointments", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Set<Appointment>> getAppointments(@Body DoctorAndDateDTO doctorAndDateDTO) {
        return HttpResponse.ok(doctorService.getAppointmentsByDoctorNameAndDate(doctorAndDateDTO.getDoctorName(), doctorAndDateDTO.getDate()));
    }

    @Put(value = "/fix-appointments", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ConfirmationResponseDTO> fixAppointment(@Body AppointmentDTO appointmentDTO) {
        return HttpResponse.ok(doctorService.fixAppointment(appointmentDTO));
    }

    @Put(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ConfirmationResponseDTO> cancelAppointment(@Body AppointmentDTO appointmentDTO) {
        return HttpResponse.ok(doctorService.fixAppointment(appointmentDTO));
    }
}
