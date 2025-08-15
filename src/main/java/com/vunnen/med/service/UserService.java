package com.vunnen.med.service;

import com.vunnen.med.model.User;
import com.vunnen.med.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createNewUser(User user) {
        log.info("save user: {}", user.getId());
        userRepository.create(user);
    }

    public void deleteUser(Long userId) {
        log.info("delete user: {}", userId);
        Optional<User> user = userRepository.find(userId);
        user.ifPresentOrElse(u -> userRepository.delete(userId),
                () -> log.error("user with id {} not found", userId));
    }
}
