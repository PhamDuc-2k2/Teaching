package com.ducpham.project_01.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    @NotBlank(message = "This code is not blank")
    private String code;
    @NotBlank
    private String name;
    @PositiveOrZero()
    private long quantity;
    @PositiveOrZero
    private BigDecimal price;
}

