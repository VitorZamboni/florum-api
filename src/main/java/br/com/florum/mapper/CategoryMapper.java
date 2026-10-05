package br.com.florum.mapper;

import br.com.florum.dto.CategoryDTO;
import br.com.florum.model.Category;
import br.com.florum.model.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryDTO toDto(Category entity);

    @Mapping(target = "name", source = "category", qualifiedByName = "mapName")
    @Mapping(target = "id", source = "category", qualifiedByName = "mapId")
    CategoryDTO toDto(ProductCategory entity);

    @Named("mapName")
    default String mapName(Category entity) {
        return entity.getName();
    }

    @Named("mapId")
    default Long mapId(Category entity) {
        return entity.getId();
    }
}