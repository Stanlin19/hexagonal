package com.hexagonal.ejemplo.domain.ports.input;

import com.hexagonal.ejemplo.domain.models.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAll();
    ProductDto findById(Long id);
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto, Long id);
    void deleteById(Long id);
}
