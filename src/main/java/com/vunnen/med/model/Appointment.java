package com.vunnen.med.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Appointment {
    private long id;
    private Priority priority;//TODO: check if it's ENUM of smth like comment
    private boolean booked;

    private String appointmentType; //TODO: check if it's should be ENUM or String
    private Department department;

    private Patient patient;

    private LocalDateTime appointmentDateTime;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private String comment;
    private String diagnosis; //TODO: check if it's String or other type

    private boolean approved;
    private boolean visited; //TODO: прописывает доктор

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", priority='" + priority + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", comment='" + comment + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", approved=" + approved +
                ", visited=" + visited +
                '}';
    }
}
