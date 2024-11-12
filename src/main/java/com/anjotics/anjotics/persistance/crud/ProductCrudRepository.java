package com.anjotics.anjotics.persistance.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anjotics.anjotics.persistance.entity.Product;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    // @Query(value = "SELECT * FROM products WHERE category_id = ?", nativeQuery =
    // true) for complex queries
    // findByIdCategoriaOrderByNombreAsc
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndStatusTrue(int stockQuantity);
}
