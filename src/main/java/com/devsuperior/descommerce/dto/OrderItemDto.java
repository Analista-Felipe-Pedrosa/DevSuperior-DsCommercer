package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.OrderItem;
import lombok.Data;

@Data
public class OrderItemDto {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    public OrderItemDto(OrderItem entity) {
        this.productId = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
    }

    public Double getSubTotal(){
        return price * quantity;
    }
}
