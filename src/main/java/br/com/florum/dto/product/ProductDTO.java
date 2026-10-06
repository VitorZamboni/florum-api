package br.com.florum.dto.product;

import br.com.florum.dto.categories.CategoryDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private BigDecimal discount;

    private Integer stock;

    private Integer views;

    private Double evaluation;

    private Instant createdOn;

    private List<CategoryDTO> categories;

    private List<ProductImageDTO> images;
}
