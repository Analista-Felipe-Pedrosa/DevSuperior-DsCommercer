package com.devsuperior.descommerce.dto;

import lombok.*;

import java.time.Instant;

@Getter
@AllArgsConstructor
@ToString
public class CustomError {
    private Instant timestamp;
    private Integer stauts;
    private String error;
    private String path;

}
