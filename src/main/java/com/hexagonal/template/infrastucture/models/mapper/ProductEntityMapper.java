package com.hexagonal.template.infrastucture.models.mapper;

import com.hexagonal.template.domain.models.entity.Product;
import com.hexagonal.template.infrastucture.models.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    private ProductEntityMapper(){}

    public ProductEntity productToEntity(Product product){
        return new ProductEntity(product.getId(),
                product.getName(),
                product.getPrice(),
                product.isAvailable());
    }

    public Product entityToProduct(ProductEntity entity){
        return new Product(entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.isAvailable());
    }
}
