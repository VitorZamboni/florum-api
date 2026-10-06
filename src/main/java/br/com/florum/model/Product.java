package br.com.florum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(length = 1024)
    private String description;

    @NotNull
    private BigDecimal price;

    @Column(precision = 5, scale = 4)
    @Builder.Default
    @NotNull
    private BigDecimal discount = BigDecimal.ZERO;

    @NotNull
    private Integer stock;

    private Integer views;

    private Double evaluation;

    @Column(name = "created_on")
    private Instant createdOn;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductImage> images;
}
