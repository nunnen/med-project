package com.vunnen.med.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String priority; //TODO: check if it's ENUM of smth like comment

    @OneToOne
    private Patient patient;

    private LocalDateTime appointmentDateTime;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private String comment;
    private String diagnosis; //TODO: check if it's String or other type

    private double visualAcuity; //TODO: what format is visual acuity and should it be in Patient class?
    // TODO: add field ВГД - че это
    private boolean approved;
    private boolean visited;

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
                ", visualAcuity=" + visualAcuity +
                ", approved=" + approved +
                ", visited=" + visited +
                '}';
    }
}
