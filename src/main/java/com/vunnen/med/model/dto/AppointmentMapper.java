package com.vunnen.med.model.dto;

import com.vunnen.med.model.Appointment;

import java.util.Optional;

public class AppointmentMapper implements Mapper<Appointment, AppointmentDto> {
    @Override
    public AppointmentDto map(Appointment from) {
        Long patientId = from.getPatient().getId();
        return new AppointmentDto(
                from.getPriority(),
                from.isBooked(),
                from.getAppointmentType(),
                from.getDepartment(),
                patientId,
                from.getAppointmentDate(),
                from.getComment(),
                from.getDiagnosis(),
                from.isApproved(),
                from.isVisited()
        );
    }
}
