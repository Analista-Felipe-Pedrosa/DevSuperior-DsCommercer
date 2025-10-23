package com.devsuperior.descommerce.services;

import com.devsuperior.descommerce.dto.CategoryDto;
import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.dto.ProductMinDto;
import com.devsuperior.descommerce.entities.Category;
import com.devsuperior.descommerce.entities.Product;
import com.devsuperior.descommerce.repositories.CategoryRepository;
import com.devsuperior.descommerce.repositories.ProductRepository;
import com.devsuperior.descommerce.services.exception.DataBaseException;
import com.devsuperior.descommerce.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<CategoryDto> findAll(){
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDto(x)).toList();
    }

}
