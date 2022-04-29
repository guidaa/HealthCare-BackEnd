package com.healthcareapp.ecommerce.mapper;

import com.healthcareapp.ecommerce.dto.ProductDTO;
import com.healthcareapp.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface ProductMapper {
    ProductDTO map(Product source);

    Product map(ProductDTO source);

}
