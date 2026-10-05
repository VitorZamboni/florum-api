package br.com.florum.mapper;

import br.com.florum.dto.cart.CartDTO;
import br.com.florum.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CartItemMapper.class})
public interface CartMapper {
    Cart toEntity(CartDTO dto);

    CartDTO toDTO(Cart toEntity);
}
