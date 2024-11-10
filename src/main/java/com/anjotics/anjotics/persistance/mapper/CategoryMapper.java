package com.anjotics.anjotics.persistance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;

import com.anjotics.anjotics.domain.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    Category toCategory(com.anjotics.anjotics.persistance.entity.Category categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    com.anjotics.anjotics.persistance.entity.Category toCategoryEntity(Category categoryDomain);
}
