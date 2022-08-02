package com.desarrollo.carrito.servicios;

import java.util.List;

import com.desarrollo.carrito.dto.CategoriasDto;

public interface ICategoriaService {

    List<CategoriasDto> listarCategorias();
    CategoriasDto buscarCategoria(Long Id);
    CategoriasDto guardarCategoria (CategoriasDto categoriasDto);
    void eliminarCategoria( Long Id);
    
}
