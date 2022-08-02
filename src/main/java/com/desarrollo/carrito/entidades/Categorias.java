package com.desarrollo.carrito.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "Tbl_Categorias")
public class Categorias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Categoria")
    private Long Id;

    @Column( name = "Nombre")
    private String Nombre;
    
    @Column( name = "Imagen")
    private String Imagen;

    // @ManyToOne
    // private Productos producto;
   
   

}