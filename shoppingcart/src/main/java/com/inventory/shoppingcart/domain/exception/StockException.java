package com.inventory.shoppingcart.domain.exception;

public class StockException extends RuntimeException {
    public StockException(String message) {
        super(message);
    }
}
