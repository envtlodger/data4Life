package com.hospital;

import com.hospital.model.Appointment;
import com.hospital.model.AppointmentDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Utils {

    private Utils() {
    }

    private final static String dateFormat(LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return df.format(localDateTime);
    }

    public final static Set<AppointmentDTO> appointmentDTOList(Set<Appointment> appointments) {
        Set<AppointmentDTO> apptDTOList = new HashSet();
        for (Appointment appointment : appointments) {
//            String dateTime = dateFormat(appointment.getLocalDateTime());
            apptDTOList.add(new AppointmentDTO(appointment.getId(), "Test data for all"));
        }

        return apptDTOList;
    }
}

