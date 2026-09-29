package br.com.florum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table (name = "coupons")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Coupon {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    @Column(name = "discount_amount")
    private int discountAmount;

    @NotNull
    @Column(name = "expiration_date")
    private Date expirationDate;
}
