package br.com.florum.dto.order;

import br.com.florum.dto.address.AddressDTO;
import br.com.florum.dto.coupon.CouponDto;
import br.com.florum.dto.user.UserDTO;
import br.com.florum.enuns.OrderStatusEnum;
import br.com.florum.enuns.PaymentTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long id;

    private String couponCode;

    private Instant purchasedOn;

    private BigDecimal total;

    private BigDecimal discount;

    private BigDecimal shipping;

    private AddressDTO address;

    private OrderStatusEnum status;

    private PaymentTypeEnum paymentTypeEnum;

    private List<OrderItemDTO> orderItems;
}