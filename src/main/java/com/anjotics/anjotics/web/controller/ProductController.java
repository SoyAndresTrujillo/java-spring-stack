package com.anjotics.anjotics.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjotics.anjotics.domain.ProductDomain;
import com.anjotics.anjotics.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDomain>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDomain> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<ProductDomain>> getByCategory(@PathVariable("categoryId") int categoryId) {
        Optional<List<ProductDomain>> products = productService.getByCategory(categoryId);
        /**
         * If products < 1 return not found
         */
        if (products.isPresent() && !products.get().isEmpty()) {
            return ResponseEntity.ok(products.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDomain> save(@RequestBody ProductDomain product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> delete(@PathVariable("productId") int productId) {
        return productService.delete(productId) ? ResponseEntity.ok().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
