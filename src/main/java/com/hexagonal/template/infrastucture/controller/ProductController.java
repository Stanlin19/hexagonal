package com.hexagonal.template.infrastucture.controller;

import com.hexagonal.template.domain.models.dto.ProductDto;
import com.hexagonal.template.domain.ports.input.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDto> findAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public Optional<ProductDto> findAll(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product){
        return service.save(product);
    }

    @PutMapping("{id}")
    public ProductDto update(@RequestBody ProductDto product, @PathVariable Long id){
        return service.update(product, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
