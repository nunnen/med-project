package com.vunnen.med.service;

import com.vunnen.med.model.User;
import com.vunnen.med.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        log.info("Create user");
        return userRepository.create(user);
    }

    public boolean delete(Long userId) {
        log.info("delete user-{}", userId);
        return userRepository.find(userId)
                .map(user -> {
                    userRepository.delete(userId);
                    return true;
                })
                .orElse(false);
    }
}
