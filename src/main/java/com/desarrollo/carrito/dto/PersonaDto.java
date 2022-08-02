package com.desarrollo.carrito.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersonaDto {
    private Long Id;
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String Telefono;
    private List<String> Direcciones; //Lista de Direcciones
   

}
