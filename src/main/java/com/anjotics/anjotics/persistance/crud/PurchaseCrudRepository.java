package com.anjotics.anjotics.persistance.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anjotics.anjotics.persistance.entity.Purchase;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByCustomerId(String customerId);
}
