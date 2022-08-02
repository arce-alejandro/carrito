package com.desarrollo.carrito.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    
    private int codigoRespuesta;
    private String mensaje;
    private Object data;
}
