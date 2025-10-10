package com.devsuperior.descommerce.services;

import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.entities.Product;
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
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){

        return new ProductDto(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")));
    }

    public Page<ProductDto> findAll(String name, Pageable pageable){
            return repository.searchByName(name, pageable).map(ProductDto::new);
    }

    @Transactional
    public ProductDto insert(ProductDto dto){
        return new ProductDto(repository.save(new Product(dto)));
    }

    @Transactional
    public ProductDto update(Long id, ProductDto dto){
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            repository.save(entity);
            return new ProductDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }
    //
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException(("Recurso não encontrado"));
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha na integridade Referencial");
        }
    }

    private void copyDtoToEntity(ProductDto dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }
}
