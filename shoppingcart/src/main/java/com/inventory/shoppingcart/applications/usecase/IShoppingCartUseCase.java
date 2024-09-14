package com.inventory.shoppingcart.applications.usecase;

import com.inventory.shoppingcart.domain.dto.AddProductDto;
import com.inventory.shoppingcart.domain.dto.ShoppingCartDto;

import java.util.List;

public interface IShoppingCartUseCase {
    List<ShoppingCartDto> getShoppingCart(String token);

    ShoppingCartDto addProduct(String token, AddProductDto addProductDto);
}
