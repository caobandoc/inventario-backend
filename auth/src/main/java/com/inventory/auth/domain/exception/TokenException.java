package com.inventory.auth.domain.exception;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
}
