package com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_cart")
public class ShoppingCart {

    @EmbeddedId
    private ShoppingCartPK id;

    private Integer quantity;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Long productId;

}
