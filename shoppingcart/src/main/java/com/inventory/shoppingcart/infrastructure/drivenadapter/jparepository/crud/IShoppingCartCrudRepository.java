package com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.crud;

import com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShoppingCartCrudRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByUserId(Long userId);
}
