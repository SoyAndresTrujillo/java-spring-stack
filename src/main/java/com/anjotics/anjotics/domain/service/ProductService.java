package com.anjotics.anjotics.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjotics.anjotics.domain.ProductDomain;
import com.anjotics.anjotics.domain.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDomain> getAll() {
        return productRepository.getAll();
    }

    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<ProductDomain> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public ProductDomain save(ProductDomain product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        // try {
        // productRepository.delete(productId);
        // return true;
        // } catch (EmptyResultDataAccessException e) {
        // return false;
        // }
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
