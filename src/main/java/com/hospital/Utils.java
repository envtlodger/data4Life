package com.hospital;

import com.hospital.model.Appointment;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public final class Utils {

    private Utils() {

    }

    public final static String createNewId(List<Appointment> appointmentIds) {
        String lastAppointmentId = appointmentIds.get(appointmentIds.size() - 1).getId();

        int lastIndex = Integer.parseInt(lastAppointmentId.substring(1));

        int newLastIndex = ++lastIndex;

        String newLastNumber = String.valueOf(newLastIndex);

      return "A" + newLastNumber;
    }

    public final static boolean checkIfTimeWithinRange(LocalDateTime localDateTime) {
        LocalTime localTime = localDateTime.toLocalTime();

        int minutes = localTime.getMinute();
        int seconds = localTime.getSecond();

        LocalTime startTime = LocalTime.of(8,0);
        LocalTime endTime = LocalTime.of(16,0);

        return !localTime.isBefore(startTime) && !localTime.isAfter(endTime) && minutes == 0 && seconds == 0;
    }

}
