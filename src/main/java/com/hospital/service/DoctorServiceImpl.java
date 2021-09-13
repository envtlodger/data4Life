package com.hospital.service;

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
        System.out.println(date);

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
        for(Appointment appointment : getDoctorAppointments) {
            if(appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
                isThereAppointmentForDoctorAtTime = true;
            }
        }

        for(Appointment appointment : getPatientAppointments) {
            if(appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
                isThereAppointmentForPatientAtTime = true;
            }
        }

        String message =  "save not successful";;

        if(!isThereAppointmentForDoctorAtTime && !isThereAppointmentForPatientAtTime) {
            List<Appointment> appointmentIds = appointmentRepository.listOrderByIdDesc();

            String lastAppointmentId = appointmentIds.get(0).getId();

            int lastIndex = Integer.parseInt(lastAppointmentId.substring(1));

            int newLastIndex = ++lastIndex;

            String newLastNumber = String.valueOf(newLastIndex);

            String newId = "A" + newLastNumber;

            appointmentRepository.save(new Appointment(newId, appointmentDTO.getLocalDateTime(), doctor.get().getId(), patient.get().getId()));
            message = "save successful";
        }

//
//        // check if both have free appointments at that datetime
//        boolean isThereAppointmentForDoctorAtGivenDate = false;
//        boolean isThereAppointmentForPatientAtGivenDate = false;
//        for (Appointment appointment : doctor.get().getAppointments()) {
//            if (appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
//                isThereAppointmentForDoctorAtGivenDate = true;
//            }
//        }
//
//        for (Appointment appointment : patient.get().getAppointments()) {
//            if (appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime())) {
//                isThereAppointmentForPatientAtGivenDate = true;
//            }
//        }
//
        //List<Appointment> appointmentIds = appointmentRepository.listOrderByIdDesc();

//        String lastAppointmentId = appointmentIds.get(1).getId();
//
//        int lastIndex = Integer.parseInt(lastAppointmentId.substring(1));
//
//        int newLastIndex = ++lastIndex;
//
//        String newLastNumber = String.valueOf(newLastIndex);
//
//        String newId = "A" + newLastNumber;

//        if (!isThereAppointmentForDoctorAtGivenDate && !isThereAppointmentForPatientAtGivenDate) {
//            Appointment appointment = new Appointment(newId, appointmentDTO.getLocalDateTime());
//            doctor.get().getAppointments().add(appointment);
//            patient.get().getAppointments().add(appointment);
//            doctorRepository.update(doctor.get());
//            patientRepository.update(patient.get());
//            message = "save successful: Appointment id: " + newId;
//        } else {
//            message = " save not successful";
//        }

        return new ConfirmationResponseDTO(message);
    }

    @Override
    public ConfirmationResponseDTO cancelAppointment(AppointmentDTO appointmentDTO) {
//        Optional<Doctor> doctor =   doctorRepository.findByName(appointmentDTO.getDoctorName());
//        Optional<Patient> patient = patientRepository.findByName(appointmentDTO.getPatientName());

        String message = null;

//        for (Appointment appointment : doctor.get().getAppointments()) {
//            if (appointment.getLocalDateTime().isEqual(appointmentDTO.getLocalDateTime()) && appointment.getDoctor().getName().equals(appointmentDTO.getDoctorName())
//                    && appointment.getPatient().getName().equals(appointmentDTO.getPatientName())) {
//                 appointmentRepository.delete(appointment);
//                message = "deleted successfully";
//            }
//        }

        if (message == null) {
            message = "unable to delete";
        }
        return new ConfirmationResponseDTO(message);
    }

}
