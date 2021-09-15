package com.hospital.service;

import com.hospital.Utils;
import com.hospital.model.*;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Inject
    private DoctorRepository doctorRepository;

    @Inject
    private AppointmentRepository appointmentRepository;

    @Inject
    private PatientRepository patientRepository;

    @Override
    public Set<Appointment> getAppointmentsByDoctorNameAndDate(String doctorName, LocalDate date) {
        Optional<Doctor> doctor = doctorRepository.findByName(doctorName);
        Doctor doctor1 = doctor.get();
        List<Appointment> appointmentsForDoctor = appointmentRepository.findAllByDoctorId(doctor.get().getId());

        Set<Appointment> appointments = new HashSet<>();
        for (Appointment appointment : appointmentsForDoctor) {
            if (appointment.getLocalDateTime().toLocalDate().isEqual(date)) {
                appointments.add(appointment);
            }
        }

        return appointments;
    }

    @Override
    public ConfirmationResponseDTO fixAppointment(AppointmentDTO appointmentDTO) {
        Optional<Doctor> doctor = doctorRepository.findByName(appointmentDTO.getDoctorName());
        Optional<Patient> patient = patientRepository.findByName(appointmentDTO.getPatientName());

        List<Appointment> getDoctorAppointments = appointmentRepository.findAllByDoctorId(doctor.get().getId());
        List<Appointment> getPatientAppointments = appointmentRepository.findAllByPatientId(patient.get().getId());

        boolean isThereAppointmentForDoctorAtTime = false;
        boolean isThereAppointmentForPatientAtTime = false;
        for (Appointment appointment : getDoctorAppointments) {
            if (appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
                isThereAppointmentForDoctorAtTime = true;
            }
        }

        for (Appointment appointment : getPatientAppointments) {
            if (appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
                isThereAppointmentForPatientAtTime = true;
            }
        }

        String message = "save not successful";

        if (!isThereAppointmentForDoctorAtTime && !isThereAppointmentForPatientAtTime && Utils.checkIfTimeWithinRange(appointmentDTO.getLocalDateTime())) {
            List<Appointment> appointmentIds = appointmentRepository.listOrderById();
            String newId = Utils.createNewId(appointmentIds);
            appointmentRepository.save(new Appointment(newId, appointmentDTO.getLocalDateTime(), doctor.get().getId(), patient.get().getId()));
            message = "save successful: Appointment id: " + newId;
        }

        return new ConfirmationResponseDTO(message);
    }

    @Override
    public ConfirmationResponseDTO cancelAppointment(AppointmentDTO appointmentDTO) {
        Optional<Doctor> doctor = doctorRepository.findByName(appointmentDTO.getDoctorName());
        Optional<Patient> patient = patientRepository.findByName(appointmentDTO.getPatientName());

        String doctorId = doctor.get().getId();
        String patientId = patient.get().getId();

        List<Appointment> getAppointmentsForDoctorAndPatient = appointmentRepository.findAllByDoctorIdAndPatientId(doctorId, patientId);

        String message = "unable to delete";

        for (Appointment appointment : getAppointmentsForDoctorAndPatient) {
            if (appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
                appointmentRepository.delete(appointment);
                message = "deleted successfully";
            }
        }

        return new ConfirmationResponseDTO(message);
    }

}
