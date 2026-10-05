package br.com.florum.dto.cart;

import br.com.florum.dto.product.SimpleProductDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartItemDTO {
    private Long id;

    private Integer quantity;

    private SimpleProductDTO product;
}
