package br.com.florum.dto.coupon;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CouponDto {
    private Long id;

    @NotNull
    private String code;

    private BigDecimal discountAmount;

    private Instant expiresOn;
}