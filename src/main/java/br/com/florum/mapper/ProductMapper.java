package br.com.florum.mapper;

import br.com.florum.dto.ProductDTO;
import br.com.florum.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CategoryMapper.class)
public interface ProductMapper {
    ProductDTO toDto(Product entity);
}
