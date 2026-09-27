package br.com.florum.mapper;

import br.com.florum.dto.UserDTO;
import br.com.florum.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDTO dto);

    UserDTO toDTO(User entity);
}
