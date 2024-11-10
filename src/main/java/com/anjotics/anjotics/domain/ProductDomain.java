package com.anjotics.anjotics.domain;

import java.math.BigDecimal;

public class ProductDomain {
    private int idProduct;
    private String name;
    private int idCategory;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private CategoryDomain category;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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
