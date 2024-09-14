package com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer;

import com.inventory.shoppingcart.domain.dto.ProductDto;
import com.inventory.shoppingcart.domain.exception.ProductNotFoundException;
import com.inventory.shoppingcart.domain.repository.IProductRepository;
import com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer.mapper.ProductMapper;
import com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer.model.response.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductRestConsumer implements IProductRepository {

    private final RestTemplate restTemplate;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProduct(Long productId) {
        String url = "lb://product-service/product/" + productId;
        Product product;
        try{
            product = restTemplate.getForObject(url, Product.class);
        }catch (Exception e){
            throw new ProductNotFoundException("Product not found");
        }

        return productMapper.toDto(product);

    }
}
