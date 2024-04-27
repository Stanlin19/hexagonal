package com.hexagonal.ejemplo.infrastucture.controller;

import com.hexagonal.ejemplo.domain.models.dto.ProductDto;
import com.hexagonal.ejemplo.domain.ports.input.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ProductDto findAll(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product){
        return service.save(product);
    }

}
