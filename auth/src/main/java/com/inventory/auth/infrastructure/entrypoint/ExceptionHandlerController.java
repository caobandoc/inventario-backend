package com.inventory.auth.infrastructure.entrypoint;

import com.inventory.auth.infrastructure.entrypoint.exception.RegisteredUserException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(RegisteredUserException.class)
    public ProblemDetail handleRegisteredUserException(RuntimeException ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ex.getMessage());
    }


}
