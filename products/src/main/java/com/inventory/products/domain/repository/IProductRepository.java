package com.inventory.products.domain.repository;

import com.inventory.products.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<ProductDto> getProducts();
    Optional<ProductDto> getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
}
