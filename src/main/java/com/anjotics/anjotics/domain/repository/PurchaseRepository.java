package com.anjotics.anjotics.domain.repository;

import java.util.List;
import java.util.Optional;

import com.anjotics.anjotics.domain.PurchaseDomain;

public interface PurchaseRepository {
    List<PurchaseDomain> getAll();

    Optional<List<PurchaseDomain>> getByCustomer(String customerId);

    PurchaseDomain save(PurchaseDomain purchase);
}
