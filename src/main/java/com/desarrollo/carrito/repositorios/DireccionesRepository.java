package com.desarrollo.carrito.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollo.carrito.entidades.Direcciones;


@Repository
@Transactional
public interface DireccionesRepository  extends CrudRepository <Direcciones, Long> {
    
}
