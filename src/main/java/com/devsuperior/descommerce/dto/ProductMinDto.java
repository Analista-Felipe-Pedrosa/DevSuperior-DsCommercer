package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductMinDto {

    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ProductMinDto(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }
}
