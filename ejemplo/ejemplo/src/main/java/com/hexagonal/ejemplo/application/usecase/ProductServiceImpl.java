package com.hexagonal.ejemplo.application.usecase;

import com.hexagonal.ejemplo.domain.models.dto.ProductDto;
import com.hexagonal.ejemplo.domain.models.mapper.ProductMapper;
import com.hexagonal.ejemplo.domain.ports.input.IProductService;
import com.hexagonal.ejemplo.domain.ports.output.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(IProductRepository iProductRepository, ProductMapper productMapper) {
        this.iProductRepository = iProductRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        return iProductRepository.findAll()
                .stream()
                .map(productMapper::toProductDto)
                .toList();
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.toProductDto(iProductRepository.findById(id));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return productMapper.toProductDto(iProductRepository.save(productMapper.toProduct(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto, Long id) {
        return productMapper.toProductDto(iProductRepository.update(productMapper.toProduct(productDto), id));
    }

    @Override
    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }
}
