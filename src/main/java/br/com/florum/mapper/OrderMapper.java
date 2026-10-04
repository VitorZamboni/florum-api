package br.com.florum.mapper;

import br.com.florum.dto.OrderDTO;
import br.com.florum.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderItemMapper.class, UserMapper.class, CouponMapper.class})
public interface OrderMapper {
    Order toEntity(OrderDTO dto);

    OrderDTO toDto(Order entity);
}
