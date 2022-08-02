package com.desarrollo.carrito.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDto {
    
    private Long Id;
    private Long Id_Persona;
    private Long Id_Producto;
    private Long Cantidad;
    private Long Precio;
    private String Nombre_Producto;
    private String Nombre_Persona;
    private String Direccion;


}
