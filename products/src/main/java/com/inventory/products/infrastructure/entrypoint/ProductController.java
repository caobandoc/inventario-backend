package com.inventory.products.infrastructure.entrypoint;

import com.inventory.products.applications.usecase.IProductUseCase;
import com.inventory.products.domain.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductUseCase productsUseCase;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productsUseCase.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productsUseCase.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productsUseCase.createProduct(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productsUseCase.updateProduct(id, productDto));
    }

    @PutMapping("/{id}/reduce-stock")
    public ResponseEntity<ProductDto> reduceStock(@PathVariable Long id, @RequestParam Integer quantity) {
        return ResponseEntity.ok(productsUseCase.reduceStock(id, quantity));
    }

    @PutMapping("/{id}/increase-stock")
    public ResponseEntity<ProductDto> increaseStock(@PathVariable Long id, @RequestParam Integer quantity) {
        return ResponseEntity.ok(productsUseCase.increaseStock(id, quantity));
    }
}
