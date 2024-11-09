package com.anjotics.anjotics.persistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchases_products")
public class PurchasesProduct {
    @EmbeddedId
    private PurchasesProductPK id;

    private Integer quantity;

    private Double total;

    private Boolean status;

    public PurchasesProductPK getId() {
        return id;
    }

    public void setId(PurchasesProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
