package br.com.florum.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Double discount;
    private Double evaluation;
    private String mainImageUrl;
}
