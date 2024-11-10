package com.anjotics.anjotics.domain.repository;

import java.util.List;
import java.util.Optional;

import com.anjotics.anjotics.domain.ProductDomain;

public interface ProductRepository {
    List<ProductDomain> getAll();

    Optional<List<ProductDomain>> getByCategory(int categoryId);

    Optional<List<ProductDomain>> getLessStock(int quantity);

    Optional<ProductDomain> getProduct(int productId);

    ProductDomain save(ProductDomain product);

    void delete(int productId);
}
