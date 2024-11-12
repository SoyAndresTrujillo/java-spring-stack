package com.anjotics.anjotics.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anjotics.anjotics.domain.ProductDomain;
import com.anjotics.anjotics.domain.repository.ProductRepository;
import com.anjotics.anjotics.persistance.crud.ProductCrudRepository;
import com.anjotics.anjotics.persistance.entity.Product;
import com.anjotics.anjotics.persistance.mapper.ProductMapper;

@Repository
public class ProductRepositoryImplementation implements ProductRepository {
    /**
     * This is the ProductCrudRepository instance that is used to perform CRUD
     * operations on the Product entity. (implementation for interface)
     */
    @Autowired
    private ProductCrudRepository productCrudRepository;

    /**
     * When a component or beans from spring then it is @Autowired is requiered.
     */
    @Autowired
    private ProductMapper mapper;

    /**
     * This method is used to get all products from the database.
     * 
     * @return List<ProductDomain>
     */
    @Override
    public List<ProductDomain> getAll() {
        /**
         * In this case, the findAll method is natively implemented by Spring Data JPA
         * and returns a List<ProductDomain>.
         */
        return mapper.toProducts((List<Product>) productCrudRepository.findAll());
    }

    /**
     * This method is used to get all products by category from the database.
     *
     * @param categoryId
     * @return List<ProductDomain>
     */
    @Override
    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        /**
         * In this case, the findByCategoryIdOrderByNameAsc method is a custom query
         * defined
         * in the ProductCrudRepository interface and returns a List<ProductDomain>.
         */
        return Optional.of(mapper.toProducts(productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId)));
    }

    /**
     * This method is used to get all products with less stock than the specified
     * quantity from the database.
     * 
     * @param quantity
     * @return Optional<List<ProductDomain>>
     */
    @Override
    public Optional<List<ProductDomain>> getLessStock(int quantity) {
        /**
         * In this case, the findByStockQuantityLessThanAndStatusTrue method is a custom
         * query defined in the ProductCrudRepository interface and returns an
         * Optional<List<ProductDomain>>.
         */
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatusTrue(quantity);
        /**
         * The :: is a lambda expression that is used to convert the List<Product> to
         * List<ProductDomain>.
         * or use products.map(products -> mapper.toProducts(products));
         */
        return products.map(mapper::toProducts);
    }

    /**
     * This method is used to get a product by its id from the database.
     * 
     * @param productId
     * @return Optional<ProductDomain>
     */
    @Override
    public Optional<ProductDomain> getProduct(int productId) {
        /**
         * In this case, the findById method is natively implemented by Spring Data JPA
         * and returns an Optional<ProductDomain> because the product might not exist in
         * the
         * database.
         */
        return productCrudRepository.findById(productId).map(mapper::toProduct);
    }

    /**
     * This method is used to save a product to the database.
     * 
     * @param product
     * @return ProductDomain
     */
    @Override
    public ProductDomain save(ProductDomain product) {
        /**
         * In this case, the save method is natively implemented by Spring Data JPA and
         * returns the saved product entity and then it is converted to ProductDomain.
         */
        return mapper.toProduct(productCrudRepository.save(mapper.toProductEntity(product)));
    }

    /**
     * This method is used to delete a product from the database.
     * 
     * @param productId
     */
    @Override
    public void delete(int productId) {
        /**
         * In this case, the deleteById method is natively implemented by Spring Data
         * JPA.
         */
        productCrudRepository.deleteById(productId);
    }
}
