package com.hexagonal.template.domain.models.mapper;

import com.hexagonal.template.domain.models.dto.ProductDto;
import com.hexagonal.template.domain.models.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private ProductMapper(){}

    public ProductDto toProductDto(Product p){
        return new ProductDto(p.getName(), p.getPrice(), p.isAvailable());
    }

    public Product toProduct(ProductDto p, Long id){
        return new Product(id,p.name(), p.price(), p.available());
    }
}
