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
@Table(name = "Tbl_Personas")
public class Personas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona")
    private Long Id;

    @Column( name = "Nombres")
    private String Nombres;

    @Column( name = "Apellidos")
    private String Apellidos;

    @Column( name = "Email")
    private String Email;

    @Column( name = "Telefono")
    private String Telefono;

    @Column( name = "Direcciones")
    private String Direcciones;

   

}
