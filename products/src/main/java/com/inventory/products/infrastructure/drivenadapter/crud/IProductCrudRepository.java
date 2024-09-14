package com.inventory.products.infrastructure.drivenadapter.crud;

import com.inventory.products.infrastructure.drivenadapter.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCrudRepository extends JpaRepository<Product, Long> {
}
