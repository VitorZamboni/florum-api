package br.com.florum.dto.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private Double evaluation;
    private String mainImageUrl;
}
