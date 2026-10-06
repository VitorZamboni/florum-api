package br.com.florum.dto.order;

import br.com.florum.dto.product.ProductQuantityDTO;
import br.com.florum.enuns.PaymentTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderDTO {
    @NotNull
    private Long addressId;

    @NotNull
    private PaymentTypeEnum paymentType;

    private String couponCode;

    @Valid
    @NotEmpty
    private List<ProductQuantityDTO> items;
}
