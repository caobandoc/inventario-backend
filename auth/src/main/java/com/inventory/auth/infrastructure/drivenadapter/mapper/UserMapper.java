package com.inventory.auth.infrastructure.drivenadapter.mapper;

import com.inventory.auth.domain.dto.RegisterUserDto;
import com.inventory.auth.domain.dto.UserDto;
import com.inventory.auth.infrastructure.drivenadapter.entities.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserAuth toEntity (RegisterUserDto registerUserDto){
        return UserAuth.builder()
                .email(registerUserDto.getEmail())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .name(registerUserDto.getName())
                .build();
    }

    public UserDto toDto(UserAuth userAuth) {
        return UserDto.builder()
                .email(userAuth.getEmail())
                .build();
    }
}
