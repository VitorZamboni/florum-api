package br.com.florum.dto.order;

import br.com.florum.enuns.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleOrderDTO {
    private Long id;
    private Instant purchasedOn;
    private BigDecimal total;
    private OrderStatusEnum status;
}
