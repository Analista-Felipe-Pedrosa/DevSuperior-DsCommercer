package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.Payment;
import lombok.Data;

import java.time.Instant;

@Data
public class PaymentDto {

    private Long id;
    private Instant moment;

    public PaymentDto(Payment entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
    }
}
