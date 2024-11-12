package com.anjotics.anjotics.domain;

import java.math.BigDecimal;

public class ProductDomain {
    private int productId;
    private String name;
    private int categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private CategoryDomain category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryDomain getCategory() {
        return category;
    }

    public void setCategory(CategoryDomain category) {
        this.category = category;
    }
}
