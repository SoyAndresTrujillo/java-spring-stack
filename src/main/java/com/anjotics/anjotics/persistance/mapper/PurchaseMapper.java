package com.anjotics.anjotics.persistance.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.anjotics.anjotics.domain.PurchaseDomain;
import com.anjotics.anjotics.persistance.entity.Purchase;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class })
public interface PurchaseMapper {

    @Mappings({
        @Mapping(source = "status", target = "state"),
        @Mapping(source = "products", target = "items")
    })
    PurchaseDomain toPurchaseDomain(Purchase purchaseEntity);

    List<PurchaseDomain> toPurchasesDomain(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Purchase toPurchaseEntity(PurchaseDomain purchaseDomain);
}
