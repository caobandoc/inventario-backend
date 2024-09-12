package com.inventory.auth.infrastructure.drivenadapter.mapper;

import com.inventory.auth.domain.dto.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginResponse toDto(String token, long expirationTime) {
        return LoginResponse.builder()
                .token(token)
                .expiresIn(expirationTime)
                .build();
    }
}
