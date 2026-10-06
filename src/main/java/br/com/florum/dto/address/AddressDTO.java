package br.com.florum.dto.address;

import br.com.florum.dto.user.UserDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class AddressDTO {
    private Long id;

    @NotNull
    @Size(min = 8, max = 8)
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
    @Size(min = 3, max = 70)
    private String country;

    private String complement;
}
