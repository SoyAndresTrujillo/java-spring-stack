package com.anjotics.anjotics.persistance;

import com.anjotics.anjotics.persistance.crud.ProductCrudRepository;
import com.anjotics.anjotics.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    /**
     * This is the ProductCrudRepository instance that is used to perform CRUD
     * operations on the Product entity. (implementation for interface)
     */
    private ProductCrudRepository productCrudRepository;

    /**
     * This method is used to get all products from the database.
     * 
     * @return List<Product>
     */
    public List<Product> getAll() {
        /**
         * In this case, the findAll method is natively implemented by Spring Data JPA
         * and returns a List<Product>.
         */
        return (List<Product>) productCrudRepository.findAll();
    }

    /**
     * This method is used to get all products by category from the database.
     * 
     * @param categoryId
     * @return List<Product>
     */
    public List<Product> getByCategory(int categoryId) {
        /**
         * In this case, the findByCategoryIdByNameAsc method is a custom query defined
         * in the ProductCrudRepository interface and returns a List<Product>.
         */
        return productCrudRepository.findByCategoryIdByNameAsc(categoryId);
    }

    /**
     * This method is used to get all products with less stock than the specified
     * quantity from the database.
     * 
     * @param quantity
     * @return Optional<List<Product>>
     */
    public Optional<List<Product>> getLessStock(int quantity) {
        /**
         * In this case, the findByStockQuantityLessThanAndStatusTrue method is a custom
         * query defined in the ProductCrudRepository interface and returns an
         * Optional<List<Product>>.
         */
        return productCrudRepository.findByStockQuantityLessThanAndStatusTrue(quantity);
    }

    /**
     * This method is used to get a product by its id from the database.
     * 
     * @param productId
     * @return Optional<Product>
     */
    public Optional<Product> getProduct(int productId) {
        /**
         * In this case, the findById method is natively implemented by Spring Data JPA
         * and returns an Optional<Product> because the product might not exist in the
         * database.
         */
        return productCrudRepository.findById(productId);
    }

    /**
     * This method is used to save a product to the database.
     * 
     * @param product
     * @return Product
     */
    public Product save(Product product) {
        /**
         * In this case, the save method is natively implemented by Spring Data JPA and
         * returns the saved product.
         */
        return productCrudRepository.save(product);
    }

    /**
     * This method is used to delete a product from the database.
     * 
     * @param productId
     */
    public void delete(int productId) {
        /**
         * In this case, the deleteById method is natively implemented by Spring Data
         * JPA.
         */
        productCrudRepository.deleteById(productId);
    }
}
