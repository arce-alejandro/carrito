package com.desarrollo.carrito.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductosDto {
    private Long Id;
    private String Nombre;
    private String Descripcion; 
    private Long Id_Categoria;
    private Long Cantidad;
    private Long Precio;
    private String Imagen;
    // private List<String> Categorias;
}
