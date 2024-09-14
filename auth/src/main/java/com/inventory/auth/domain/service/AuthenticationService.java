package com.inventory.auth.domain.service;

import com.inventory.auth.applications.IAuthUseCase;
import com.inventory.auth.domain.dto.LoginResponseDto;
import com.inventory.auth.domain.dto.RegisterUserDto;
import com.inventory.auth.domain.dto.UserDto;
import com.inventory.auth.infrastructure.drivenadapter.repository.LoginRepository;
import com.inventory.auth.infrastructure.drivenadapter.repository.UserRepository;
import com.inventory.auth.domain.exception.RegisteredUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService implements IAuthUseCase {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    private final AuthenticationManager authenticationManager;

    public UserDto register(RegisterUserDto input) {
        //validar
        userRepository.findByEmail(input.getEmail()).ifPresent(user -> {
            log.error("User %s already exists", user.getEmail());
            throw new RegisteredUserException("User already exists");
        });
        //crear
        return userRepository.save(input);
    }

    public LoginResponseDto login(UserDto input) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
        return loginRepository.login(input);
    }

}
