package br.com.florum.mapper;

import br.com.florum.dto.CartItemDTO;
import br.com.florum.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class})
public interface CartItemMapper {
    CartItem toEntity(CartItemDTO dto);

    CartItemDTO toDto(CartItem entity);
}
