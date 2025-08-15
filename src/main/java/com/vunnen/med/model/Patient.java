package com.vunnen.med.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String initials;
    private int age;
    private LocalDate birthYear; //TODO: сделать датой рождения
    private String region;
    private String address;
    private String phone;
    private String secondPhone;
    private String visualAcuity; //TODO: CAN BE String and Number
    private double internalEyePressure; //TODO: ВГД (внутриглазное давление) and maybe move to Appointment later

    private Appointment appointment; //TODO: check if it's list or only one appointment

}
