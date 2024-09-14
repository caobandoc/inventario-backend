package com.inventory.products.applications.usecase;

import com.inventory.products.domain.dto.ProductDto;

import java.util.List;

public interface IProductUseCase {
    List<ProductDto> getProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);

    ProductDto reduceStock(Long id, Integer quantity);
    ProductDto increaseStock(Long id, Integer quantity);
}
