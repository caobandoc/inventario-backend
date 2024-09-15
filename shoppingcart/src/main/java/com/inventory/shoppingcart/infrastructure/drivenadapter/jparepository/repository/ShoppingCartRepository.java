package com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.repository;

import com.inventory.shoppingcart.domain.dto.AddProductDto;
import com.inventory.shoppingcart.domain.dto.ShoppingCartDto;
import com.inventory.shoppingcart.domain.repository.IShoppingCartRepository;
import com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.crud.IShoppingCartCrudRepository;
import com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.entities.ShoppingCart;
import com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.mapper.ShoppingCartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShoppingCartRepository implements IShoppingCartRepository {

    private final IShoppingCartCrudRepository shoppingCartJpaRepository;
    private final ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShoppingCartDto> getShoppingCart(Long userId) {
        List<ShoppingCart> shoppingCart = shoppingCartJpaRepository.findByUserId(userId);
        return shoppingCartMapper.toShoppingCartDto(shoppingCart);
    }

    @Override
    public ShoppingCartDto addProduct(Long userId, AddProductDto addProductDto) {
        ShoppingCart shoppingCart = shoppingCartMapper.toShoppingCart(userId, addProductDto);
        ShoppingCart save = shoppingCartJpaRepository.save(shoppingCart);
        return shoppingCartMapper.toShoppingCartDto(save);
    }

}
