package com.anjotics.anjotics.web.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.anjotics.anjotics.domain.ProductDomain;
import com.anjotics.anjotics.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductDomain> getAll() {
        return productService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductDomain>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @GetMapping("/{productId}")
    public Optional<ProductDomain> getProduct(int productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/save")
    public ProductDomain save(ProductDomain product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId) {
        return productService.delete(productId);
    }
}
