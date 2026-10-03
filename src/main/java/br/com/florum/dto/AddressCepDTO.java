package br.com.florum.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressCepDTO {
    @NotNull
    private String cep;

    @NotNull
    @JsonProperty("address")
    private String street;

    @NotNull
    private String district;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @Builder.Default
    private String country = "Brasil";
}


