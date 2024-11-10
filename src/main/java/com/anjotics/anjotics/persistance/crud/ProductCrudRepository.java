package com.anjotics.anjotics.persistance.crud;

import com.anjotics.anjotics.persistance.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    // @Query(value = "SELECT * FROM products WHERE category_id = ?", nativeQuery =
    // true) for complex queries
    // findByIdCategoriaOrderByNombreAsc
    List<Product> findByIdCategoryOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndStatusTrue(int stockQuantity);
}
