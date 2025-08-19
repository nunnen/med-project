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

    private static final Long ADMIN_ID = 1L;

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void create() {
        doReturn(ADMIN).when(userRepository).create(ADMIN);

        assertThat(userService.create(ADMIN)).isEqualTo(ADMIN);

        verify(userRepository, times(1)).create(ADMIN);
    }

    @Test
    void delete() {
        doReturn(Optional.of(ADMIN)).when(userRepository).find(ADMIN_ID);

        assertThat(userService.delete(ADMIN_ID)).isEqualTo(true);
    }
}