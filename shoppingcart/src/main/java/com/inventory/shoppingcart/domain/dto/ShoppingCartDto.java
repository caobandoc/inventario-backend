package com.inventory.shoppingcart.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDto {
    private Long userId;
    private Long productId;
    private ProductDto product;
    private Integer quantity;

}
