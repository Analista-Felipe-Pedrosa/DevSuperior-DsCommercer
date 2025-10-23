package com.devsuperior.descommerce.services;

import com.devsuperior.descommerce.dto.OrderDto;
import com.devsuperior.descommerce.dto.OrderItemDto;
import com.devsuperior.descommerce.dto.ProductDto;
import com.devsuperior.descommerce.entities.*;
import com.devsuperior.descommerce.repositories.OrderItemRepository;
import com.devsuperior.descommerce.repositories.OrderRepository;
import com.devsuperior.descommerce.repositories.ProductRepository;
import com.devsuperior.descommerce.services.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDto findById(Long id){

        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

        authService.validateSelfOrAdmin(order.getClient().getId());
        return new OrderDto(order);

    }

    @Transactional
    public OrderDto insert(@Valid OrderDto dto) {

        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDto itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDto(order);

    }
}
