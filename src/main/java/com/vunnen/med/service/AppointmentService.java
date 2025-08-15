package com.vunnen.med.service;

import com.vunnen.med.model.Appointment;
import com.vunnen.med.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Appointment getAppointment(Long appointmentId) {
        log.info("Get appointment with id {}", appointmentId);
        Optional<Appointment> appointment = appointmentRepository.find(appointmentId);
        if (appointment.isPresent()) {
            return appointment.get();
        } else {
            log.error("Appointment with id {} not found", appointmentId);
            return null;
        }
    }

    public List<Appointment> getAllAppointments() {
        log.info("Get all appointments");
        return appointmentRepository.findAll();
    }

    public void createNewAppointment(Appointment appointment) {
        log.info("Create new appointment");
        appointmentRepository.create(appointment);
    }

    public void updateAppointment(Long appointmentId) {
        log.info("Update appointment with id {}", appointmentId);
        Optional<Appointment> appointment = appointmentRepository.find(appointmentId);
        appointment.ifPresent(appointmentRepository::update);
    }

    public void deleteAppointment(Long appointmentId) {
        log.info("Delete appointment {}", appointmentId);
        appointmentRepository.delete(appointmentId);
    }

    public void bookAppointment(Long appointmentId) {
        log.info("Book appointment {}", appointmentId);
        Optional<Appointment> appointment = appointmentRepository.find(appointmentId);

        appointment.ifPresent(ap -> ap.setBooked(true));
    }

    public void unbookAppointment(Long appointmentId) {
        log.info("Unbook appointment {}", appointmentId);
        Optional<Appointment> appointment = appointmentRepository.find(appointmentId);

        appointment.ifPresent(ap -> ap.setBooked(false));
    }

    public void editAppointmentComment(Long appointmentId, String comment) {
        log.info("Edit appointment comment {}", appointmentId);
        Optional<Appointment> appointment = appointmentRepository.find(appointmentId);
        appointment.ifPresent(ap -> ap.setComment(comment));
    }

    public void editAppointmentType(Long appointmentId, String type) {
        log.info("Edit appointment type {}", appointmentId);
        Optional<Appointment> appointment = appointmentRepository.find(appointmentId);
        appointment.ifPresent(ap -> ap.setAppointmentType(type));
    }
}
