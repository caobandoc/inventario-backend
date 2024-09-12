package com.inventory.auth.applications;

import com.inventory.auth.domain.dto.LoginResponse;
import com.inventory.auth.domain.dto.RegisterUserDto;
import com.inventory.auth.domain.dto.UserDto;

public interface IAuthUseCase {
    UserDto register(RegisterUserDto input);
    LoginResponse login(UserDto input);
}
