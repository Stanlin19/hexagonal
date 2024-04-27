package com.hexagonal.template.domain.ports.input;

import com.hexagonal.template.domain.models.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductDto> getAll();
    Optional<ProductDto> findById(Long id);
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto, Long id);
    void deleteById(Long id);
}
