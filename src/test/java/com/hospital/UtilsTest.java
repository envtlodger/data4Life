package com.hospital;


import com.hospital.model.Appointment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MicronautTest
public class UtilsTest {


    @Test
    void createNewId() {

        List<Appointment> appointments = new ArrayList<>();

        Appointment appointment1 = new Appointment("A1", LocalDateTime.of(2018, 03, 8, 9, 0, 0), "D1", "P1");
        Appointment appointment2 = new Appointment("A2", LocalDateTime.of(2018, 03, 8, 10, 0, 0), "D1", "P1");

        appointments.add(appointment1);
        appointments.add(appointment2);

        String newId = Utils.createNewId(appointments);

        Assertions.assertEquals("A3", newId);
    }

    @Test
    void checkIfTimeWithinRange() {

        LocalDateTime timeAppropriateRange = LocalDateTime.of(2018, 03, 8, 9, 0, 0);

        LocalDateTime timeInAppropriateAfterRange = LocalDateTime.of(2018, 03, 8, 17, 0, 0);

        LocalDateTime timeInAppropriateBeforeRange = LocalDateTime.of(2018, 03, 8, 7, 0, 0);

        LocalDateTime timeInAppropriateTiming = LocalDateTime.of(2018, 03, 8, 7, 15, 0);


        Assertions.assertTrue(Utils.checkIfTimeWithinRange(timeAppropriateRange));

        Assertions.assertFalse(Utils.checkIfTimeWithinRange(timeInAppropriateAfterRange));

        Assertions.assertFalse(Utils.checkIfTimeWithinRange(timeInAppropriateBeforeRange));

        Assertions.assertFalse(Utils.checkIfTimeWithinRange(timeInAppropriateTiming));
    }
}
