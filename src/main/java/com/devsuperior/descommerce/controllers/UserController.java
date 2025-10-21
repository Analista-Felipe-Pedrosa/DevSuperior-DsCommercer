package com.devsuperior.descommerce.controllers;

import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.dto.UserDto;
import com.devsuperior.descommerce.services.ProductService;
import com.devsuperior.descommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDto> getMe(){
        return ResponseEntity.ok(service.getMe());
    }

}
