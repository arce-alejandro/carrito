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
@Table(name = "Tbl_Direcciones")
public class Direcciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Direccion")
    private Long Id;

    @Column(name = "Id_Persona")
    private Long Id_Persona;

    @Column(name = "Direccion")
    private Long Direccion;


   

}
