package br.com.florum.dto.cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateCartItemDTO {
    @NotNull
    private Long productId;

    @NotNull
    @Positive
    private Integer quantity;
}
