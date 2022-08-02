package com.desarrollo.carrito.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollo.carrito.entidades.Categorias;



@Repository
@Transactional
public interface CategoriasRepository  extends CrudRepository <Categorias , Long> {
    
}
