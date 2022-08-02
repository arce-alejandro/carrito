package com.desarrollo.carrito.servicios;

import java.util.List;

import com.desarrollo.carrito.dto.FacturaDto;

public interface IFacturaService {
    List<FacturaDto> listarFacturas();
    FacturaDto buscarFactura(Long Id);
    FacturaDto guardarFactura(FacturaDto facturaDto);
    void eliminarFactura(Long Id);

}
