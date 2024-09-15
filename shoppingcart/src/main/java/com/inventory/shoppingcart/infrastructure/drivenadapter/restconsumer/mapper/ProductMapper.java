package com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer.mapper;

import com.inventory.shoppingcart.domain.dto.ProductDto;
import com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer.model.response.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

        public ProductDto toDto(Product product) {
            return ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .build();
        }
}
