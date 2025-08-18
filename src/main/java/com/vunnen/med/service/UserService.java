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

    public User createNewUser(User user) {
        log.info("save user: {}", user.getId());
        return userRepository.create(user);
    }

    public boolean deleteUser(Long userId) {
        log.info("delete user-{}", userId);
        Optional<User> user = userRepository.find(userId);
        if (user.isPresent()) {
            userRepository.delete(userId);
            return true;
        }
        else {
            log.info("user-{} not found", userId);
            return false;
        }
    }
}
