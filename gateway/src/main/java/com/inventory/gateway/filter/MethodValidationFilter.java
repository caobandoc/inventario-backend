package com.inventory.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class MethodValidationFilter extends AbstractGatewayFilterFactory<MethodValidationFilter.Config> {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public MethodValidationFilter(WebClient.Builder webClientBuilder) {
        super(MethodValidationFilter.Config.class);
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            HttpMethod method = exchange.getRequest().getMethod();
            List<HttpMethod> methods = Arrays.asList(config.getMethods());

            if (!methods.contains(method)) {
                return chain.filter(exchange);
            }

            HttpHeaders headers = exchange.getRequest().getHeaders();
            String token = headers.getFirst(HttpHeaders.AUTHORIZATION);

            if (token == null || !token.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            token = token.substring(7);

            return webClientBuilder.build()
                    .get()
                    .uri("lb://auth-service/auth/claims/role?token=" + token)
                    .retrieve()
                    .bodyToMono(String.class)
                    .flatMap(role -> {
                        if (role.equals("ROLE_ADMIN")) {
                            return chain.filter(exchange);
                        } else {
                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            return exchange.getResponse().setComplete();
                        }
                    });

        };
    }

    public static class Config {
        private HttpMethod[] methods;

        public HttpMethod[] getMethods() {
            return methods;
        }

        public void setMethods(HttpMethod[] methods) {
            this.methods = methods;
        }
    }
}
