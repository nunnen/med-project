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

    public Optional<Appointment> findById(Long appointmentId) {
        log.info("Find appointment with id {}", appointmentId);
        return appointmentRepository.find(appointmentId);
    }

    public List<Appointment> findAll() {
        log.info("Find all appointments");
        return appointmentRepository.findAll();
    }

    public Appointment create(Appointment appointment) {
        log.info("Create new appointment");
        return appointmentRepository.create(appointment);
    }

    public Optional<Appointment> updateAppointment(Long appointmentId, Appointment updatedAppointment) {
        log.info("Update appointment with id {}", appointmentId);
        return appointmentRepository.find(appointmentId)
                .map(appointment -> {
                    appointment.setPriority(updatedAppointment.getPriority());
                    appointment.setBooked(updatedAppointment.isBooked());
                    appointment.setAppointmentType(updatedAppointment.getAppointmentType());
                    appointment.setDepartment(updatedAppointment.getDepartment());
                    appointment.setPatient(updatedAppointment.getPatient());
                    appointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
                    appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                    appointment.setComment(updatedAppointment.getComment());
                    appointment.setDiagnosis(updatedAppointment.getDiagnosis());
                    appointment.setApproved(updatedAppointment.isApproved());
                    appointment.setVisited(updatedAppointment.isVisited());
                    return appointment;
                });
    }

    public boolean deleteAppointment(Long appointmentId) {
        log.info("Delete appointment {}", appointmentId);
        return appointmentRepository.find(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointmentId);
                    return true;
                })
                .orElse(false);
    }
}
