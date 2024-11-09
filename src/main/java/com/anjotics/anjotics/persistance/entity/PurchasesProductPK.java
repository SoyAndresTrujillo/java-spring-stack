package com.anjotics.anjotics.persistance.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class PurchasesProductPK implements Serializable {
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "product_id")
    private Integer productId;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
