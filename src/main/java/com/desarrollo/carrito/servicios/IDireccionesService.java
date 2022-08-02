package com.desarrollo.carrito.servicios;

import java.util.List;

import com.desarrollo.carrito.dto.DireccionesDto;

public interface IDireccionesService {
    List<DireccionesDto> listarDirecciones();
    DireccionesDto buscarDirecciones(Long Id);
    DireccionesDto guardarDireccion(DireccionesDto direccionesDto);
    void eliminarDireccion(Long Id);

}
