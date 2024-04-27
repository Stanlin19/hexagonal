package com.hexagonal.template.application.usecase;

import com.hexagonal.template.domain.commons.exceptions.ProductNotFoundException;
import com.hexagonal.template.domain.models.dto.ProductDto;
import com.hexagonal.template.domain.models.entity.Product;
import com.hexagonal.template.domain.models.mapper.ProductMapper;
import com.hexagonal.template.domain.ports.input.IProductService;
import com.hexagonal.template.domain.ports.output.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.hexagonal.template.domain.commons.constant.Constants.PRODUCTNOTFOUND;

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
    public Optional<ProductDto> findById(Long id) {
        Optional<Product> one = iProductRepository.findById(id);
        if(one.isEmpty()){
            throw new ProductNotFoundException(PRODUCTNOTFOUND);
        }
        return Optional.ofNullable(productMapper.toProductDto(one.orElseThrow()));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return productMapper.toProductDto(iProductRepository.save(productMapper.toProduct(productDto, null)));
    }

    @Override
    public ProductDto update(ProductDto productDto, Long id) {
        if(findById(id).isEmpty()){
            throw new ProductNotFoundException(PRODUCTNOTFOUND);
        }
        return productMapper.toProductDto(iProductRepository.update(productMapper.toProduct(productDto, id), id));
    }

    @Override
    public void deleteById(Long id) {
        if(findById(id).isEmpty()){
            throw new ProductNotFoundException(PRODUCTNOTFOUND);
        }
        iProductRepository.deleteById(id);
    }
}
