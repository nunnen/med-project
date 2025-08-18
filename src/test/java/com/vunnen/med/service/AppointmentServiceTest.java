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

    private final Appointment APPOINTMENT = Appointment.builder()
            .booked(false)
            .appointmentType("eyes")
            .patient(new Patient())
            .comment("comment")
            .build();

    private final Long APPOINTMENT_ID = 1L;

    @Test
    void getAppointment() {
        doReturn(Optional.of(APPOINTMENT)).when(appointmentRepository).find(APPOINTMENT_ID);

        assertThat(appointmentService.getAppointment(APPOINTMENT_ID)).isEqualTo(APPOINTMENT);
    }

    @Test
    void getAllAppointments() {
        doReturn(List.of(APPOINTMENT)).when(appointmentRepository).findAll();

        assertThat(appointmentService.getAllAppointments()).isNotEmpty();
        assertThat(appointmentService.getAllAppointments()).hasSize(1);
    }

    @Test
    void createNewAppointment() {
        doReturn(APPOINTMENT).when(appointmentRepository).create(APPOINTMENT);

        assertThat(appointmentService.createNewAppointment(APPOINTMENT)).isEqualTo(APPOINTMENT);
    }

    @Test
    void updateAppointment() {
        doReturn(APPOINTMENT).when(appointmentRepository).get(APPOINTMENT_ID);
        doReturn(APPOINTMENT).when(appointmentRepository).update(APPOINTMENT);

        assertThat(appointmentService.updateAppointment(APPOINTMENT_ID)).isEqualTo(APPOINTMENT);
    }
}