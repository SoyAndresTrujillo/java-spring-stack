package com.anjotics.anjotics.persistance.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.anjotics.anjotics.domain.PurchaseItemDomain;
import com.anjotics.anjotics.persistance.entity.PurchasesProduct;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {
    @Mappings({
        @Mapping(source = "id.productId", target = "productId"),
        @Mapping(source = "quantity", target = "quantity"),
        @Mapping(source = "status", target = "active")
    })
    PurchaseItemDomain toPurchaseItemEntity(PurchasesProduct product);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "purchase", ignore = true),
        @Mapping(target = "product", ignore = true),
        @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchasesProduct toPurchasesProductDomain(PurchaseItemDomain productDomain);
}
