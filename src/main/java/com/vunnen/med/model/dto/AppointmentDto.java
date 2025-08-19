package com.vunnen.med.model.dto;

import com.vunnen.med.model.Department;
import com.vunnen.med.model.Priority;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class AppointmentDto {
    private Priority priority;//TODO: check if it's ENUM of smth like comment
    private boolean booked;
    private String appointmentType; //TODO: check if it's should be ENUM or String
    private Department department;
    private Long patientId;
    private LocalDate appointmentDate;
    private String comment;
    private String diagnosis; //TODO: check if it's String or other type
    private boolean approved;
    private boolean visited; //TODO: прописывает доктор
}
