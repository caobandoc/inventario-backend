package com.inventory.products.infrastructure.drivenadapter.mapper;

import com.inventory.products.domain.dto.ProductDto;
import com.inventory.products.infrastructure.drivenadapter.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    public List<ProductDto> toProductDtoList(List<Product> list) {
        return list.stream()
                .map(this::toProductDto)
                .toList();
    }

    public Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();
    }

}
