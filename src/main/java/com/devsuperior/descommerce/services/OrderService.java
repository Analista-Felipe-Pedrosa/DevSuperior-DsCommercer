package com.devsuperior.descommerce.services;

import com.devsuperior.descommerce.dto.OrderDto;
import com.devsuperior.descommerce.repositories.OrderRepository;
import com.devsuperior.descommerce.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDto findById(Long id){

        return new OrderDto(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")));
    }
}
