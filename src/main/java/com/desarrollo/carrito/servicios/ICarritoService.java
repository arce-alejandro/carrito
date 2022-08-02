package com.desarrollo.carrito.servicios;

import java.util.List;

import com.desarrollo.carrito.dto.CarritoDto;

public interface ICarritoService {
    List<CarritoDto> listarCarrito();
    CarritoDto buscarCarrito(Long Id);
    CarritoDto guardarCarrito(CarritoDto carritoDto);
    void eliminarCarrito(Long Id);

}
