package com.inventory.auth.infrastructure.entrypoint.exception;

public class RegisteredUserException extends RuntimeException {
    public RegisteredUserException(String message) {
        super(message);
    }
}
