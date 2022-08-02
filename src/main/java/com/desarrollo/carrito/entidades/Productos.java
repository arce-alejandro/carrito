package com.desarrollo.carrito.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "Tbl_Productos")
public class Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Producto")
    private Long Id;

    @Column(name = "Id_Categoria")
    private Long Id_Categoria;

    @Column( name = "Nombre")
    private String Nombre;
    
    @Column( name = "Descripcion")
    private String Descripcion;

    @Column( name = "Cantidad")
    private Long Cantidad;

    @Column( name = "Precio")
    private Long Precio;
    
    @Column( name = "Imagen")
    private String Imagen;
    
    // @OneToMany(mappedBy = " producto ")
    // List<Categorias> Categorias;

}
