package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.User;
import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String name;

    public ClientDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
