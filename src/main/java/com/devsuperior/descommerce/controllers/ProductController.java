package com.devsuperior.descommerce.controllers;

import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> findAll(
            @RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){
        return ResponseEntity.ok(service.findAll(name ,pageable));
    }

    @PostMapping
    public ResponseEntity<ProductDto> insert(@Valid @RequestBody ProductDto dto){
        return ResponseEntity.status(201).body(service.insert(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id,@Valid @RequestBody ProductDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
