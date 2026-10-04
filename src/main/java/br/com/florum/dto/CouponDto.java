package br.com.florum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CouponDto {
    private Long id;

    @NotNull
    private String code;

    private int discountAmount;

    private Date expirationDate;
}