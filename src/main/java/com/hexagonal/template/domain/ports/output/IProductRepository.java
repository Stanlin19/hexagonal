package com.hexagonal.template.domain.ports.output;

import com.hexagonal.template.domain.models.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Product update(Product product, Long id);
    void deleteById(Long id);
}
