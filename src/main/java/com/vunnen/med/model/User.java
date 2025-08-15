package com.vunnen.med.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private long id;
    private Role role;
    private String name;
    private String username;
    private String password;


}
