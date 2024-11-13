package com.anjotics.anjotics.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anjotics.anjotics.domain.PurchaseDomain;
import com.anjotics.anjotics.domain.repository.PurchaseRepository;
import com.anjotics.anjotics.persistance.crud.PurchaseCrudRepository;
import com.anjotics.anjotics.persistance.entity.Purchase;
import com.anjotics.anjotics.persistance.mapper.PurchaseMapper;

@Repository
public class PurchaseRepositoryImplementation implements PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDomain> getAll() {
        return mapper.toPurchasesDomain((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDomain>> getByCustomer(String customerId) {
        return purchaseCrudRepository.findByCustomerId(customerId)
                .map(purchases -> mapper.toPurchasesDomain(purchases));
    }

    @Override
    public PurchaseDomain save(PurchaseDomain purchase) {
        Purchase purchaseEntity = mapper.toPurchaseEntity(purchase);
        purchaseEntity.getProducts().forEach(product -> product.setPurchase(purchaseEntity));
        return mapper.toPurchaseDomain(purchaseCrudRepository.save(purchaseEntity));
    }
}
