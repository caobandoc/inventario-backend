package com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer;

import com.inventory.shoppingcart.domain.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TokenRestConsumer implements ITokenRepository {

    private final RestTemplate restTemplate;

    @Override
    public Long getUserId(String token) {
        String url = "lb://auth-service/auth/claims/id?token=" + token.substring(7);
        return restTemplate.getForObject(url, Long.class);
    }

}
