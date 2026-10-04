package br.com.florum.mapper;

import br.com.florum.dto.ProductImageDTO;
import br.com.florum.model.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductImageMapper {
    ProductImage toEntity(ProductImageDTO dto);

    ProductImageDTO toDto(ProductImage entity);
}
