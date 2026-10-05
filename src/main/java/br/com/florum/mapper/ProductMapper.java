package br.com.florum.mapper;

import br.com.florum.dto.ProductDTO;
import br.com.florum.dto.SimpleProductDTO;
import br.com.florum.model.Product;
import br.com.florum.model.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class, ProductImageMapper.class})
public interface ProductMapper {
    @Mapping(target = "categories", source = "productCategories")
    ProductDTO toDto(Product entity);

    @Mapping(target = "mainImageUrl", source = "images", qualifiedByName = "mapMainImage")
    SimpleProductDTO toSimpleDto(Product entity);

    @Named("mapMainImage")
    default String mapMainImage(List<ProductImage> images) {
        if (images == null || images.isEmpty()) return null;

        return images.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(
                        img -> img.getSortIndex() != null ? img.getSortIndex() : Integer.MAX_VALUE
                ))
                .map(ProductImage::getUrl)
                .orElse(null);
    }
}
