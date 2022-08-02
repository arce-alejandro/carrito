package com.desarrollo.carrito.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "Tbl_Factura")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Factura")
    private Long Id;

    @Column(name = "Id_Producto")
    private Long Id_Producto;

    @Column( name = "Id_Persona")
    private Long Id_Persona;
    
    @Column( name = "Cantidad")
    private Long Cantidad;

    @Column( name = "Precio")
    private Long Precio;

    @Column( name = "Nombre_Producto")
    private String Nombre_Producto;
    
    @Column( name = "Nombre_Persona")
    private String Nombre_Persona;
    
    @Column( name = "Direccion")
    private String Direccion;

    
   

}
