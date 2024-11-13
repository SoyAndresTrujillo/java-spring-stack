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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Get all products
     * 
     * @return List of products
     */
    @GetMapping("/all")
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDomain.class)))),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<List<ProductDomain>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    /**
     * Get a product by its ID
     * @param productId
     * @return
     */
    @GetMapping("/{productId}")
    @Operation(summary = "Get a product by ID", description = "Returns a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDomain.class))),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<ProductDomain> getProduct(@Parameter(description = "The ID of the product to retrieve", required = true, example = "1") @PathVariable("productId") int productId) {
        return productService.getProduct(productId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get products by category
     * @param categoryId
     * @return List of products
     */
    @GetMapping("/by-category/{categoryId}")
    @Operation(summary = "Get products by category", description = "Returns a list of products by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDomain.class)))),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<List<ProductDomain>> getByCategory(@Parameter(description = "The ID of the category to retrieve", required = true, example = "1") @PathVariable("categoryId") int categoryId) {
        Optional<List<ProductDomain>> products = productService.getByCategory(categoryId);
        /**
         * If products < 1 return not found
         */
        if (products.isPresent() && !products.get().isEmpty()) {
            return ResponseEntity.ok(products.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Save a product
     * @param product
     * @return
     */
    @PostMapping("/save")
    @Operation(summary = "Save a product", description = "Saves a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDomain.class)))
    })
    public ResponseEntity<ProductDomain> save(@Parameter(description = "The product to save", required = true) @RequestBody ProductDomain product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    /**
     * Delete a product by its ID
     * @param productId
     * @return
     */
    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "Delete a product by ID", description = "Deletes a product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<Void> delete(@Parameter(description = "The ID of the product to delete", required = true, example = "1") @PathVariable("productId") int productId) {
        return productService.delete(productId) ? ResponseEntity.ok().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
