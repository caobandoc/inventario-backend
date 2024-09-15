package com.inventory.shoppingcart.infrastructure.entrypoint;

import com.inventory.shoppingcart.applications.usecase.IShoppingCartUseCase;
import com.inventory.shoppingcart.domain.dto.AddProductDto;
import com.inventory.shoppingcart.domain.dto.ProductDto;
import com.inventory.shoppingcart.domain.dto.ShoppingCartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final IShoppingCartUseCase shoppingCartUseCase;

    @GetMapping
    public ResponseEntity<List<ShoppingCartDto>> getShoppingCart(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(shoppingCartUseCase.getShoppingCart(token));
    }

    @PostMapping
    public ResponseEntity<ShoppingCartDto> addShoppingCart(@RequestHeader("Authorization") String token, @RequestBody AddProductDto addProductDto) {
        return ResponseEntity.ok(shoppingCartUseCase.addProduct(token, addProductDto));
    }


}
