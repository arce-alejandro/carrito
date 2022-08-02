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
@Table(name = "Tbl_Carrito")
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Carrito")
    private Long Id;

    @Column(name = "Id_Producto")
    private Long Id_Producto;

    @Column( name = "Id_Persona")
    private Long Id_Persona;
    
    @Column( name = "Cantidad")
    private Long Cantidad;

    @Column( name = "Precio")
    private Long Precio;

    
   

}
