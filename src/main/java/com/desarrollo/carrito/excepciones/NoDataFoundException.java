package com.desarrollo.carrito.excepciones;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException()
    {
        super("No existen registros");
    }
    
}
