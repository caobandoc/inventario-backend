package com.inventory.products.infrastructure.drivenadapter.repository;

import com.inventory.products.domain.dto.ProductDto;
import com.inventory.products.domain.repository.IProductRepository;
import com.inventory.products.infrastructure.drivenadapter.crud.IProductCrudRepository;
import com.inventory.products.infrastructure.drivenadapter.entities.Product;
import com.inventory.products.infrastructure.drivenadapter.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements IProductRepository {

    private final IProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getProducts() {
        return productMapper.toProductDtoList(productCrudRepository.findAll());
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {
        return productCrudRepository.findById(id).map(productMapper::toProductDto);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product newProduct = productMapper.toProduct(productDto);
        return productMapper.toProductDto(productCrudRepository.save(newProduct));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product newProduct = productMapper.toProduct(productDto);
        return productMapper.toProductDto(productCrudRepository.save(newProduct));
    }
}
