package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String name;

    public CategoryDto(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
