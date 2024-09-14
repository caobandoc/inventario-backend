package com.inventory.auth.applications;

import com.inventory.auth.domain.dto.LoginResponseDto;
import com.inventory.auth.domain.dto.RegisterUserDto;
import com.inventory.auth.domain.dto.UserDto;

public interface IAuthUseCase {
    UserDto register(RegisterUserDto input);
    LoginResponseDto login(UserDto input);
}
