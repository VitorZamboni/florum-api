package br.com.florum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(
    name = "order_items",
    uniqueConstraints = @UniqueConstraint(
        name = "uk_order_items_order_product",
        columnNames = {"order_id", "product_id"}
    )
)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
