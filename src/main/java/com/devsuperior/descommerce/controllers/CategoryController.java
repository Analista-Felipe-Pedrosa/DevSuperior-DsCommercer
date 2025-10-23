package com.devsuperior.descommerce.controllers;

import com.devsuperior.descommerce.dto.CategoryDto;
import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.dto.ProductMinDto;
import com.devsuperior.descommerce.services.CategoryService;
import com.devsuperior.descommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
