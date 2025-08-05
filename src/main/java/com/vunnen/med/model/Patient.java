package com.vunnen.med.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String initials;
    private int age;
    private int birthYear;
    private String region;
    private String address;
    private String phone;
    private String secondPhone;

    @OneToOne
    private Appointment appointment; //TODO: check if it's list or only one appointment

}
