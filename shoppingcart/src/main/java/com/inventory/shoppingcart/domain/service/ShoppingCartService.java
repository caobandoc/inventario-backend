package com.inventory.shoppingcart.domain.service;

import com.inventory.shoppingcart.applications.usecase.IShoppingCartUseCase;
import com.inventory.shoppingcart.applications.usecase.ITokenUseCase;
import com.inventory.shoppingcart.domain.dto.AddProductDto;
import com.inventory.shoppingcart.domain.dto.ProductDto;
import com.inventory.shoppingcart.domain.dto.ShoppingCartDto;
import com.inventory.shoppingcart.domain.exception.StockException;
import com.inventory.shoppingcart.domain.repository.IProductRepository;
import com.inventory.shoppingcart.domain.repository.IShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService implements IShoppingCartUseCase {

    private final IShoppingCartRepository shoppingCartRepository;
    private final IProductRepository productRepository;
    private final ITokenUseCase tokenService;

    @Override
    public List<ShoppingCartDto> getShoppingCart(String token) {
        Long userId = tokenService.getUserId(token);
        List<ShoppingCartDto> list = shoppingCartRepository.getShoppingCart(userId);
        list.forEach(shoppingCartDto ->
                shoppingCartDto
                        .setProduct(productRepository
                                .getProduct(shoppingCartDto.getProductId())));
        return list;
    }

    @Override
    public ShoppingCartDto addProduct(String token, AddProductDto addProductDto) {
        Long userId = tokenService.getUserId(token);
        ProductDto product = productRepository.getProduct(addProductDto.getProductId());

        if (product.getStock() < addProductDto.getQuantity()) {
            throw new StockException("Stock not available");
        }

        ShoppingCartDto shoppingCartDto = shoppingCartRepository.addProduct(userId, addProductDto);
        shoppingCartDto.setProduct(product);
        return shoppingCartDto;
    }
}
