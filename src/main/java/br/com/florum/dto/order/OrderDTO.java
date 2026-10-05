package br.com.florum.dto.order;

import br.com.florum.dto.address.AddressDTO;
import br.com.florum.dto.coupon.CouponDto;
import br.com.florum.dto.user.UserDTO;
import br.com.florum.enuns.PaymentTypeEnum;
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