package com.anjotics.anjotics.persistance;

import com.anjotics.anjotics.persistance.crud.ProductCrudRepository;
import com.anjotics.anjotics.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }
}
