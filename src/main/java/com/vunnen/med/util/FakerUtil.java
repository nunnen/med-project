package com.vunnen.med.util;

import com.vunnen.med.model.Appointment;
import com.vunnen.med.model.Patient;
import com.vunnen.med.model.Role;
import com.vunnen.med.model.User;
import com.vunnen.med.repository.AppointmentRepository;
import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FakerUtil {
    private static final FakerUtil fakerUtil = new FakerUtil();
    private final Faker faker = new Faker(new Locale("ru"));
    private final AppointmentRepository appointmentRepository = AppointmentRepository.getInstance();
    private final ZoneId zoneId = ZoneId.systemDefault();

    private FakerUtil() {
    }

    public static FakerUtil getInstance() {
        return fakerUtil;
    }

    public User createFakeUser() {
        User user = User.builder()
                .username(faker.internet().username())
                .password(faker.internet().password())
                .role(faker.random().nextEnum(Role.class))
                .phone(faker.phoneNumber().phoneNumber())
                .build();

        return user;
    }

    public List<User> createFakeUsers(int size) {
        List<User> users = new ArrayList<>();
        int cycle = faker.random().nextInt(size);
        for (int i = 0; i < cycle; i++) {
            users.add(createFakeUser());
        }
        return users;
    }

    public Patient createFakePatient() {
        Appointment appointment = createFakeAppointment();

        Patient patient = Patient.builder()
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .patronymic(faker.name().firstName())
                .age(faker.random().nextInt(50))
                .birthYear(faker.timeAndDate().birthday().getYear())
                .region(faker.address().cityName())
                .address(faker.address().streetAddress())
                .phone(faker.phoneNumber().phoneNumber())
                .appointment(appointment)
                .build();

        String initials = patient.getSurname().substring(0, 1) + "." + patient.getName().substring(0, 1) + "." + patient.getPatronymic().substring(0, 1) + ".";
        patient.setInitials(initials);
        appointment.setPatient(patient);

        appointmentRepository.save(appointment);
        return patient;
    }

    public List<Patient> createFakePatients(int size) {
        List<Patient> patients = new ArrayList<>();
        int cycle = faker.random().nextInt(size);
        for (int i = 0; i < cycle; i++) {
            patients.add(createFakePatient());
        }
        return patients;
    }

    public Appointment createFakeAppointment() {
        String[] priorities = {"High", "Medium", "Low"};

        Appointment appointment = Appointment.builder()
                .priority(priorities[faker.random().nextInt(priorities.length)])
                .appointmentDateTime(faker.timeAndDate().past().atZone(zoneId).toLocalDateTime())
                .comment("")
                .diagnosis(faker.disease().anyDisease())
                .visualAcuity(faker.random().nextDouble())
                .approved(faker.random().nextBoolean())
                .visited(faker.random().nextBoolean())
                .build();

        LocalDateTime appointmentDateTime = appointment.getAppointmentDateTime();
        appointment.setAppointmentTime(appointmentDateTime.toLocalTime());
        appointment.setAppointmentDate(appointmentDateTime.toLocalDate());
        return appointment;
    }

}
