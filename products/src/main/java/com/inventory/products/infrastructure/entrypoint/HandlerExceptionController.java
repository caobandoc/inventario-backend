package com.inventory.products.infrastructure.entrypoint;

import com.inventory.products.domain.exception.NotFoundException;
import com.inventory.products.domain.exception.StockException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleRegisteredUserException(RuntimeException ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
    }

    @ExceptionHandler(StockException.class)
    public ProblemDetail handleStockException(RuntimeException ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ex.getMessage());
    }

}
