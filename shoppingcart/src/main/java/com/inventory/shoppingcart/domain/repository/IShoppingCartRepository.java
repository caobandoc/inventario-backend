package com.inventory.shoppingcart.domain.repository;

import com.inventory.shoppingcart.domain.dto.AddProductDto;
import com.inventory.shoppingcart.domain.dto.ShoppingCartDto;

import java.util.List;

public interface IShoppingCartRepository {
    List<ShoppingCartDto> getShoppingCart(Long userId);

    ShoppingCartDto addProduct(Long userId, AddProductDto addProductDto);
}
