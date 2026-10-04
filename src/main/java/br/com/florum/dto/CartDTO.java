package br.com.florum.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartDTO {
    private Long id;

    @NotNull
    private UserDTO user;

    private List<CartItemDTO> cartItems;
}
