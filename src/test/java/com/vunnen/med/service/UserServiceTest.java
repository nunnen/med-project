package com.vunnen.med.service;

import com.vunnen.med.model.Role;
import com.vunnen.med.model.User;
import com.vunnen.med.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private final User ADMIN = User.builder()
            .name("adminName")
            .username("admin")
            .password("admin")
            .role(Role.ADMIN)
            .build();

    private final Long ADMIN_ID = 1L;

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void createNewUser() {
        doReturn(true).when(userRepository).create(ADMIN);

        assertThat(userService.createNewUser(ADMIN)).isEqualTo(ADMIN);

        verify(userRepository, times(1)).create(ADMIN);
    }

    @Test
    void deleteUser() {
        doReturn(Optional.of(ADMIN)).when(userRepository).find(ADMIN_ID);

        assertThat(userService.deleteUser(ADMIN_ID)).isEqualTo(true);
    }
}