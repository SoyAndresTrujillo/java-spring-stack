package com.anjotics.anjotics.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjotics.anjotics.domain.PurchaseDomain;
import com.anjotics.anjotics.domain.repository.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDomain> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDomain>> getByCustomer(String customerId) {
        return purchaseRepository.getByCustomer(customerId);
    }

    public PurchaseDomain save(PurchaseDomain purchase) {
        return purchaseRepository.save(purchase);
    }
}
