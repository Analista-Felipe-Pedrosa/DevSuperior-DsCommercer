package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.Category;
import com.devsuperior.descommerce.entities.Product;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductDto {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 400, message = "descrição precisa ter de  no mínimo 3 e máixmo 400 caracteres")
    private String description;
    @NotNull(message = "Campo requerido")
    @Positive
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve ter ao menos um categoria")
    private List<CategoryDto> categories = new ArrayList<>();

    public ProductDto(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        for (Category cat : product.getCategories()){
            categories.add(new CategoryDto(cat));
        }
    }

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }
}
