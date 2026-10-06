package br.com.florum.mapper;

import br.com.florum.dto.order.OrderItemDTO;
import br.com.florum.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class})
public interface OrderItemMapper {
    OrderItemDTO toDto(OrderItem entity);
}