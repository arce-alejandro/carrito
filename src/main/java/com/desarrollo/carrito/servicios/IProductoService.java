package com.desarrollo.carrito.servicios;

import java.util.List;

import com.desarrollo.carrito.dto.ProductosDto;

public interface IProductoService {
    List<ProductosDto> listarProductos();
    ProductosDto buscarProducto(Long Id);
    ProductosDto guardarProducto(ProductosDto productosDto);
    void eliminarProducto(Long Id);

}
