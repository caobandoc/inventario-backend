package com.inventory.shoppingcart.domain.service;

import com.inventory.shoppingcart.applications.usecase.ITokenUseCase;
import com.inventory.shoppingcart.domain.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService implements ITokenUseCase {

    private final ITokenRepository tokenRepository;

    @Override
    public Long getUserId(String token) {
        return tokenRepository.getUserId(token);
    }
}
