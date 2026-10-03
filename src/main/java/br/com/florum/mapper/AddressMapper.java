package br.com.florum.mapper;

import br.com.florum.dto.AddressDTO;
import br.com.florum.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    Address toEntity(AddressDTO dto);

    AddressDTO toDto(Address entity);
}
