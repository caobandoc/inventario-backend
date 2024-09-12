package com.inventory.auth.infrastructure.drivenadapter.repository;

import com.inventory.auth.domain.dto.RegisterUserDto;
import com.inventory.auth.domain.dto.UserDto;
import com.inventory.auth.infrastructure.drivenadapter.crud.IUserCrudRepository;
import com.inventory.auth.infrastructure.drivenadapter.entities.UserAuth;
import com.inventory.auth.infrastructure.drivenadapter.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final IUserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserDto save(RegisterUserDto input) {
        UserAuth userAuth = userCrudRepository.save(userMapper.toEntity(input));
        return userMapper.toDto(userAuth);

    }

    public Optional<UserDto> findByEmail(String email) {
        return userCrudRepository.findByEmail(email).map(userMapper::toDto);
    }
}
