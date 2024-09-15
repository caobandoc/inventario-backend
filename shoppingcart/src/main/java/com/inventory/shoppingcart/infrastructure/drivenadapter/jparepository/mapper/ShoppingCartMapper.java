package com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.mapper;

import com.inventory.shoppingcart.domain.dto.AddProductDto;
import com.inventory.shoppingcart.domain.dto.ShoppingCartDto;
import com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.entities.ShoppingCart;
import com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.entities.ShoppingCartPK;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartMapper {

    public List<ShoppingCartDto> toShoppingCartDto(List<ShoppingCart> shoppingCart) {
        return shoppingCart.stream()
                .map(this::toShoppingCartDto)
                .toList();
    }

    public ShoppingCartDto toShoppingCartDto(ShoppingCart shoppingCart) {
        return ShoppingCartDto.builder()
                .userId(shoppingCart.getUserId())
                .productId(shoppingCart.getProductId())
                .quantity(shoppingCart.getQuantity())
                .build();
    }

    public ShoppingCart toShoppingCart(Long userId, AddProductDto addProductDto) {
        return ShoppingCart.builder()
                .id(toShoppingCartPK(userId, addProductDto.getProductId()))
                .userId(userId)
                .productId(addProductDto.getProductId())
                .quantity(addProductDto.getQuantity())
                .build();
    }

    public ShoppingCartPK toShoppingCartPK(Long userId, Long productId) {
        return ShoppingCartPK.builder()
                .userId(userId)
                .productId(productId)
                .build();
    }
}
