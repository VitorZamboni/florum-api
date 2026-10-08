package br.com.florum.dto.address;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressShippingDTO {
    @NotNull
    private String lat;

    @NotNull
    private String lng;
}
