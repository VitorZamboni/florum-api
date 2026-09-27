package br.com.florum.mapper;


import br.com.florum.dto.CategoryDTO;
import br.com.florum.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryDTO toDto(Category entity);
}