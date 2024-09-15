package com.inventory.shoppingcart.infrastructure.drivenadapter.restconsumer.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
}
