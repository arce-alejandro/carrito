package com.desarrollo.carrito.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.desarrollo.carrito.dto.CarritoDto;
import com.desarrollo.carrito.entidades.Carrito;

@Mapper(componentModel = "spring")
public interface CarritoMapper {
    CarritoMapper MAPPER = Mappers.getMapper(CarritoMapper.class);
    CarritoDto modelToDto(Carrito carrito);

    @InheritInverseConfiguration

    Carrito dtoToModel(CarritoDto carritoDto);

    List<CarritoDto> modelToDtos (List<Carrito> carrito) ;
}
