package br.com.florum.dto.order;

import br.com.florum.dto.product.SimpleProductDTO;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {
    private Long id;

    private Integer quantity;

    private BigDecimal price;

    private SimpleProductDTO product;
}
