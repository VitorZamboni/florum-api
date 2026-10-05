package br.com.florum.dto.order;

import br.com.florum.dto.product.ProductDTO;
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
