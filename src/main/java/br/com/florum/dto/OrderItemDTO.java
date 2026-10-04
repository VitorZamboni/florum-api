package br.com.florum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderItemDTO {
    private Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;

    @NotNull
    private ProductDTO product;
}
