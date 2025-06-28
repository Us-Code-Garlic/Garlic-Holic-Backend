package com.garlicholic.backend.domain;

import com.garlicholic.backend.storage.UserEntity;
import com.garlicholic.backend.storage.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReader {

    private final UserJpaRepository userJpaRepository;

    public UserEntity read(Long userId) {
        return userJpaRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
