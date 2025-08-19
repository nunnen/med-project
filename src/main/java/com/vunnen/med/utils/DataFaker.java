package com.vunnen.med.utils;

import com.vunnen.med.model.Appointment;
import com.vunnen.med.model.Department;
import com.vunnen.med.model.Patient;
import com.vunnen.med.model.Priority;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataFaker {
    private final Faker faker;

    public DataFaker() {
        this.faker = new Faker();
    }

    public Appointment createFakeAppointment() {

        return Appointment.builder()
                .priority(faker.random().nextEnum(Priority.class))
                .booked(faker.random().nextBoolean())
                .appointmentType("TestType")
                .department(faker.random().nextEnum(Department.class))
                .patient(new Patient())
                .appointmentDateTime(LocalDateTime.now())
                .comment("TestComment")
                .diagnosis(faker.disease().anyDisease())
                .approved(false)
                .visited(faker.random().nextBoolean())
                .build();
    }
}
