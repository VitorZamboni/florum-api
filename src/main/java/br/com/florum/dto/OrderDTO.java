package br.com.florum.dto;

import br.com.florum.enuns.PaymentTypeEnum;
import br.com.florum.model.Coupon;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderDTO {
    private Long id;

    @NotNull
    private UserDTO user;

    private CouponDto coupon;

    @NotNull
    private AddressDTO address;

    @NotNull
    private PaymentTypeEnum paymentTypeEnum;

    @NotNull
    private List<OrderItemDTO> orderItems;
}