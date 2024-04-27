package com.hexagonal.ejemplo.domain.ports.output;

import com.hexagonal.ejemplo.domain.models.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Product product, Long id);
    void deleteById(Long id);
}
