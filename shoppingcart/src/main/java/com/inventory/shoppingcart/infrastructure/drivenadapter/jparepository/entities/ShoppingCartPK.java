package com.inventory.shoppingcart.infrastructure.drivenadapter.jparepository.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ShoppingCartPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1807684827417491138L;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;
}
