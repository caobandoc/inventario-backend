package com.inventory.auth.infrastructure.drivenadapter.repository;

import com.inventory.auth.applications.IJwtUseCase;
import com.inventory.auth.domain.dto.LoginResponse;
import com.inventory.auth.domain.dto.UserDto;
import com.inventory.auth.infrastructure.drivenadapter.crud.IUserCrudRepository;
import com.inventory.auth.infrastructure.drivenadapter.entities.UserAuth;
import com.inventory.auth.infrastructure.drivenadapter.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoginRepository {
    private final IJwtUseCase jwtUseCase;
    private final IUserCrudRepository userCrudRepository;
    private final LoginMapper loginMapper;

    public LoginResponse login(UserDto userDto) {
        UserAuth userAuth = userCrudRepository.findByEmail(userDto.getEmail()).orElseThrow();
        String token = jwtUseCase.generateToken(userAuth);
        LoginResponse obj = loginMapper.toDto(token, jwtUseCase.getExpirationTime());
        return obj;
    }
}
