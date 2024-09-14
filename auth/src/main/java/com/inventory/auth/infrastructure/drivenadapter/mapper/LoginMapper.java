package com.inventory.auth.infrastructure.drivenadapter.mapper;

import com.inventory.auth.domain.dto.LoginResponseDto;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginResponseDto toDto(String token, long expirationTime) {
        return LoginResponseDto.builder()
                .token(token)
                .expiresIn(expirationTime)
                .build();
    }
}
