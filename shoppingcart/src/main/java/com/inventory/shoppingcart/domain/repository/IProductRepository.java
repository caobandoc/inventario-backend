package com.inventory.shoppingcart.domain.repository;

import com.inventory.shoppingcart.domain.dto.ProductDto;

public interface IProductRepository {
    ProductDto getProduct(Long productId);
}
