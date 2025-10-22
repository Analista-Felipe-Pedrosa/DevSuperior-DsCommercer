package com.devsuperior.descommerce.controllers;

import com.devsuperior.descommerce.dto.OrderDto;
import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.dto.ProductMinDto;
import com.devsuperior.descommerce.services.OrderService;
import com.devsuperior.descommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
