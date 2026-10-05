package br.com.florum.dto.product;

import br.com.florum.enuns.ProductSortEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterDTO {
    private String text;
    private Boolean promotion;
    private List<Long> categoryIds;
    private ProductSortEnum sort;
}
