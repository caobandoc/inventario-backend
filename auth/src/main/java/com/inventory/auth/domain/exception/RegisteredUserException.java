package com.inventory.auth.domain.exception;

public class RegisteredUserException extends RuntimeException {
    public RegisteredUserException(String message) {
        super(message);
    }
}
