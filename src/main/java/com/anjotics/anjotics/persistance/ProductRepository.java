package com.anjotics.anjotics.persistance;

import com.anjotics.anjotics.persistance.crud.ProductCrudRepository;
import com.anjotics.anjotics.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int categoryId) {
        return productCrudRepository.findByCategoryIdByNameAsc(categoryId);
    }

    public Optional<List<Product>> getLessStock(int quantity) {
        return productCrudRepository.findByStockQuantityLessThanAndStatusTrue(quantity);
    }
}
