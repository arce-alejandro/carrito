package com.desarrollo.carrito.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.desarrollo.carrito.dto.PersonaDto;
import com.desarrollo.carrito.entidades.Personas;


@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaMapper MAPPER = Mappers.getMapper(PersonaMapper.class);
    PersonaDto modelToDto(Personas personas);

    @InheritInverseConfiguration
    Personas dtoToModel(PersonaDto personaDto);

    List<PersonaDto> modelToDtos (List<Personas> personas) ;

}
