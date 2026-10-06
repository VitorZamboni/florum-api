package br.com.florum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @Column (length = 8)
    @Pattern(regexp = "^[0-9]{8}$")
    private String cep;

    @NotNull
    @Size(min = 3, max = 70)
    private String street;

    @NotNull
    @Column (length = 8)
    @Size (min = 1, max = 8)
    private String number;

    @NotNull
    @Size(min = 3, max = 70)
    private String district;

    @NotNull
    @Size(min = 3, max = 70)
    private String city;

    @NotNull
    @Size(min = 3, max = 70)
    private String state;

    @NotNull
    private String country = "Brasil";

    private String complement;

    @Builder.Default
    private Boolean active = true;
}
