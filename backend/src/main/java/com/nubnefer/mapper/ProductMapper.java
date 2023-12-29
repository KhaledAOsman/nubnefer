package com.nubnefer.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nubnefer.dto.ProductDto;
import com.nubnefer.entities.Product;

@Mapper(componentModel = "Spring")
public interface ProductMapper {

	@Mapping(target = "categoryName",source ="category.name")
	ProductDto map (Product entity);
	
	//map from dao to entity
	@Mapping(source = "categoryName",target ="category.name")
	Product unmap (ProductDto dto);
	
	List<ProductDto> mapList (List<Product> entities);
    List<Product> unmapList (List<ProductDto> dtos);
}
