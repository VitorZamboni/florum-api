package br.com.florum.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Size(max = 1024)
    private String description;

    @NotNull
    private BigDecimal price;

    private CategoryDTO category;
}
