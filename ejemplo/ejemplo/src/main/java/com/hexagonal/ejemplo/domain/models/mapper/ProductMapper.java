package com.hexagonal.ejemplo.domain.models.mapper;

import com.hexagonal.ejemplo.domain.models.dto.ProductDto;
import com.hexagonal.ejemplo.domain.models.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private ProductMapper(){}

    public ProductDto toProductDto(Product p){
        return new ProductDto(p.getName(), p.getPrice(), p.isAvailable());
    }

    public Product toProduct(ProductDto p){
        return new Product(p.name(), p.price(), p.available());
    }
}
