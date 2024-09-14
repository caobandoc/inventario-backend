package com.inventory.products.domain.service;

import com.inventory.products.applications.usecase.IProductUseCase;
import com.inventory.products.domain.dto.ProductDto;
import com.inventory.products.domain.exception.NotFoundException;
import com.inventory.products.domain.exception.StockException;
import com.inventory.products.domain.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductUseCase {

    private final IProductRepository productRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.getProductById(id).orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return productRepository.createProduct(productDto);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        ProductDto productDb = getProductById(id);

        productDb.setName(productDto.getName());
        productDb.setPrice(productDto.getPrice());

        return productRepository.updateProduct(productDb);
    }

    @Override
    public ProductDto reduceStock(Long id, Integer quantity) {
        validateQuantity(quantity);

        ProductDto productDb = getProductById(id);

        if (quantity > productDb.getStock()) {
            throw new StockException("Stock is not enough");
        }

        productDb.setStock(productDb.getStock() - quantity);

        return productRepository.updateProduct(productDb);

    }

    @Override
    public ProductDto increaseStock(Long id, Integer quantity) {
        validateQuantity(quantity);

        ProductDto productDb = getProductById(id);
        productDb.setStock(productDb.getStock() + quantity);

        return productRepository.updateProduct(productDb);

    }

    private void validateQuantity(Integer quantity) {
        if (quantity <= 0) {
            throw new StockException("Quantity must be greater than 0");
        }
    }
}
