package br.com.florum.dto.product;

import br.com.florum.dto.categories.CategoryDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
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

    private Double discount;

    private Integer stock;

    private Integer views;

    private Double evaluation;

    private Date createdOn;

    private List<CategoryDTO> categories;

    private List<ProductImageDTO> images;
}
