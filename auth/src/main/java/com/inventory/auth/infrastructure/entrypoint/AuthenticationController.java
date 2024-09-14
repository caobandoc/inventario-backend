package com.inventory.auth.infrastructure.entrypoint;

import com.inventory.auth.applications.IAuthUseCase;
import com.inventory.auth.applications.IJwtUseCase;
import com.inventory.auth.domain.dto.LoginResponseDto;
import com.inventory.auth.domain.dto.RegisterUserDto;
import com.inventory.auth.domain.dto.UserDto;
import com.inventory.auth.infrastructure.drivenadapter.entities.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthUseCase authUseCase;
    private final IJwtUseCase jwtUseCase;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterUserDto registerUserDto) {
        return new ResponseEntity<>(authUseCase.register(registerUserDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authUseCase.login(userDto));
    }

    @GetMapping("/validate")
    public ResponseEntity<UserAuth> validate(@RequestParam String token) {
        jwtUseCase.isValidateToken(token);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/claims/{claim}")
    public ResponseEntity<String> getClaim(@RequestParam String token, @PathVariable String claim) {
        String claimValue = jwtUseCase.extractClaim(token, claims -> claims.get(claim).toString());
        return ResponseEntity.ok(claimValue);
    }
}
