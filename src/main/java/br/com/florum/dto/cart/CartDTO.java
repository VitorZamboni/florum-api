package br.com.florum.dto.cart;

import br.com.florum.dto.user.UserDTO;
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
    private List<CartItemDTO> cartItems;
}
