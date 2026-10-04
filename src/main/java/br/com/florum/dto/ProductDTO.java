package br.com.florum.dto;

import br.com.florum.model.ProductCategory;
import br.com.florum.model.ProductImage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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

    private List<CategoryDTO> productCategories;

    private List<ProductImage> images;
}
