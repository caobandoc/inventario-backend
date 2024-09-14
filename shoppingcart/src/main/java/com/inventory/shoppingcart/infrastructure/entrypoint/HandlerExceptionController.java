package com.inventory.shoppingcart.infrastructure.entrypoint;

import com.inventory.shoppingcart.domain.exception.ProductNotFoundException;
import com.inventory.shoppingcart.domain.exception.StockException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(StockException.class)
    public ProblemDetail handleStockException(RuntimeException ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ProblemDetail handleProductNotFoundException(RuntimeException ex, HttpServletRequest request) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
    }

}
