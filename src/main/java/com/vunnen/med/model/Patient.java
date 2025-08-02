package com.vunnen.med.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
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


}
