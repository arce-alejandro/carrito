package com.desarrollo.carrito.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollo.carrito.entidades.Factura;


@Repository
@Transactional
public interface FacturaRepository extends CrudRepository <Factura, Long> {
    
}
