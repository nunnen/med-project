package com.vunnen.med.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private long id;
    private Role role;
    private String username;
    private String password;
    private String phone; // TODO: что нужно юзеру?
}
