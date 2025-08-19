package com.vunnen.med.service;

import com.vunnen.med.model.Appointment;
import com.vunnen.med.model.Patient;
import com.vunnen.med.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {
    @Mock
    private AppointmentRepository appointmentRepository;
    @InjectMocks
    private AppointmentService appointmentService;

    private final static Appointment APPOINTMENT = Appointment.builder()
            .booked(false)
            .appointmentType("eyes")
            .patient(new Patient())
            .comment("comment")
            .build();

    private final Long APPOINTMENT_ID = 1L;

    @Test
    void find() {
        doReturn(Optional.of(APPOINTMENT)).when(appointmentRepository).find(APPOINTMENT_ID);

        assertThat(appointmentService.findById(APPOINTMENT_ID)).isEqualTo(Optional.of(APPOINTMENT));
    }

    @Test
    void findAll() {
        doReturn(List.of(APPOINTMENT)).when(appointmentRepository).findAll();

        assertThat(appointmentService.findAll()).isNotEmpty();
        assertThat(appointmentService.findAll()).hasSize(1);
    }

    @Test
    void create() {
        doReturn(APPOINTMENT).when(appointmentRepository).create(APPOINTMENT);

        assertThat(appointmentService.create(APPOINTMENT)).isEqualTo(APPOINTMENT);
    }

    @Test
    void update() {
        Appointment updatedAppointment = Appointment.builder()
                .booked(true)
                .appointmentType("eyes")
                .patient(new Patient())
                .comment("comment2")
                .build();

        doReturn(Optional.of(APPOINTMENT)).when(appointmentRepository).find(APPOINTMENT_ID);

        assertThat(appointmentService.updateAppointment(APPOINTMENT_ID, updatedAppointment)).isEqualTo(Optional.of(updatedAppointment));
    }
}