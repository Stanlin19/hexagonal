package com.hexagonal.template.infrastucture.adapter;

import com.hexagonal.template.domain.models.entity.Product;
import com.hexagonal.template.domain.ports.output.IProductRepository;
import com.hexagonal.template.infrastucture.models.entity.ProductEntity;
import com.hexagonal.template.infrastucture.models.mapper.ProductEntityMapper;
import com.hexagonal.template.infrastucture.repository.ProductJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private final ProductJpaRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryImpl(ProductJpaRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }


    @Override
    public List<Product> findAll() {
        List<ProductEntity> products = productRepository.findAll();
        return products
                .stream()
                .map(productEntityMapper::entityToProduct)
                .toList();

    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(productEntityMapper::entityToProduct);
    }

    @Override
    public Product save(Product product) {
        return productEntityMapper.entityToProduct(productRepository.save(productEntityMapper.productToEntity(product)));
    }

    @Override
    public Product update(Product product, Long id) {
        return productEntityMapper.entityToProduct(productRepository.save(productEntityMapper.productToEntity(product)));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
