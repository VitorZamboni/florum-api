package br.com.florum.mapper;


import br.com.florum.dto.coupon.CouponDto;
import br.com.florum.model.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CouponMapper {
    Coupon toEntity(CouponDto dto);

    CouponDto toDto(Coupon entity);
}
