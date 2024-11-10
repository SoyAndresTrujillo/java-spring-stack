package com.anjotics.anjotics.persistance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;

import com.anjotics.anjotics.domain.ProductDomain;
import com.anjotics.anjotics.persistance.entity.Product;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "idProduct"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "idCategory"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductDomain toProduct(Product productEntity);

    List<ProductDomain> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProductEntity(ProductDomain productDomain);
}
