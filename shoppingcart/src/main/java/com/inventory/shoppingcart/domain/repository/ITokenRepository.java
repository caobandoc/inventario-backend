package com.inventory.shoppingcart.domain.repository;

public interface ITokenRepository {
    Long getUserId(String token);
}
