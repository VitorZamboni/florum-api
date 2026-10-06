package br.com.florum.dto.cart;

import br.com.florum.dto.product.ProductQuantityDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCartDTO {
    @Valid
    @NotEmpty
    private List<ProductQuantityDTO> items;
}
