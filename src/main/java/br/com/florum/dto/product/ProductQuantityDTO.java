package br.com.florum.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductQuantityDTO {
    @NotNull
    private Long productId;

    @NotNull
    @Positive
    private Integer quantity;

    public static Map<Long, Integer> sumByProduct(List<ProductQuantityDTO> items) {
        return items.stream()
            .collect(Collectors.toMap(
                ProductQuantityDTO::getProductId,
                ProductQuantityDTO::getQuantity,
                Integer::sum
            ));
    }
}
