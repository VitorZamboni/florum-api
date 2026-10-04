package br.com.florum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartItemDTO {
    private Long id;

    @NotNull
    private Integer quantity;

}
