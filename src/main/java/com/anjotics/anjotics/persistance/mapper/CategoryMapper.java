package com.anjotics.anjotics.persistance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;

import com.anjotics.anjotics.domain.CategoryDomain;
import com.anjotics.anjotics.persistance.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    CategoryDomain toCategory(Category categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategoryEntity(CategoryDomain categoryDomain);
}
