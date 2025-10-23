package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.Order;
import com.devsuperior.descommerce.entities.OrderItem;
import com.devsuperior.descommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDto client;
    private PaymentDto payment;
    @NotEmpty(message = "Deve ter pelo menos um item")
    private List<OrderItemDto> items = new ArrayList<>();

    public OrderDto() {
    }

    public OrderDto(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.client = new ClientDto(entity.getClient());
        this.payment = (entity.getPayment() == null) ? null : new PaymentDto(entity.getPayment()) ;
        for (OrderItem item : entity.getItems()){
            OrderItemDto itemDto = new OrderItemDto(item);
            items.add(itemDto);
        }
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItemDto item : items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}
