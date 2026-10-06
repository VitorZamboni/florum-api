package br.com.florum.mapper;

import br.com.florum.dto.order.OrderDTO;
import br.com.florum.dto.order.SimpleOrderDTO;
import br.com.florum.model.Coupon;
import br.com.florum.model.Order;
import br.com.florum.model.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {OrderItemMapper.class, AddressMapper.class}
)
public interface OrderMapper {
    SimpleOrderDTO toSimpleDto(Order entity);

    @Mapping(target = "couponCode", source = "coupon", qualifiedByName = "mapCouponCode")
    OrderDTO toDto(Order entity);

    @Named("mapCouponCode")
    default String mapCouponCode(Coupon coupon) {
        if (coupon == null) return null;

        return coupon.getCode();
    }
}
