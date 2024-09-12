package com.inventory.auth.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
}
