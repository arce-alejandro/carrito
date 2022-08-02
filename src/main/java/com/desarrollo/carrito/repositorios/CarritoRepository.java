package com.desarrollo.carrito.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollo.carrito.entidades.Carrito;


@Repository
@Transactional
public interface CarritoRepository extends CrudRepository <Carrito, Long> {
    
}
