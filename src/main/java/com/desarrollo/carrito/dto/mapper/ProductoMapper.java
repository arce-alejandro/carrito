package com.desarrollo.carrito.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.desarrollo.carrito.dto.ProductosDto;
import com.desarrollo.carrito.entidades.Productos;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoMapper MAPPER = Mappers.getMapper(ProductoMapper.class);
    ProductosDto modelToDto(Productos productos);

    @InheritInverseConfiguration

    Productos dtoToModel(ProductosDto productosDto);

    List<ProductosDto> modelToDtos (List<Productos> productos) ;
}
