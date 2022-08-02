package com.desarrollo.carrito.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.desarrollo.carrito.dto.CategoriasDto;
import com.desarrollo.carrito.entidades.Categorias;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper MAPPER = Mappers.getMapper(CategoriaMapper.class);
    CategoriasDto modelToDto(Categorias categorias);

    @InheritInverseConfiguration

    Categorias dtoToModel(CategoriasDto categoriasDto);

    List<CategoriasDto> modelToDtos (List<Categorias> Categorias) ;
    
}
