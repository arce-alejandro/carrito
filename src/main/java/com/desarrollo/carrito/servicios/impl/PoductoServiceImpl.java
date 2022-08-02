package com.desarrollo.carrito.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.carrito.dto.ProductosDto;
import com.desarrollo.carrito.dto.mapper.ProductoMapper;
import com.desarrollo.carrito.entidades.Productos;
import com.desarrollo.carrito.excepciones.NoDataFoundException;
import com.desarrollo.carrito.repositorios.ProductosRepository;
import com.desarrollo.carrito.servicios.IProductoService;

@Service
public class PoductoServiceImpl implements IProductoService {


    @Autowired
    ProductosRepository productosRepository;

    @Autowired
    ProductoMapper productoMapper;

    @Override
    public List<ProductosDto> listarProductos() {
        List<ProductosDto> productosDtos = new ArrayList<>();
        List<Productos> productos = (List<Productos>) productosRepository.findAll();
        productosDtos = productoMapper.modelToDtos(productos);

        return productosDtos;

    }

    @Override
    public ProductosDto buscarProducto(Long Id) {
        ProductosDto productosDto = new ProductosDto();

        if (productosRepository.findById(Id).isPresent()) {
            productosDto = productoMapper.modelToDto(productosRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return productosDto;
    }

    @Override
    public ProductosDto guardarProducto(ProductosDto productosDto) {
        if (productosDto.getId() == null) {
            Productos productos = new Productos();
            productos = productoMapper.dtoToModel(productosDto);
            productos = productosRepository.save(productos);
            productosDto = productoMapper.modelToDto(productos);
        } else {
            Productos productos = productosRepository.findById(productosDto.getId()).get();
            productos = productoMapper.dtoToModel(productosDto);
            productos = productosRepository.save(productos);
            productosDto = productoMapper.modelToDto(productos);

        }
        return null;
    }

    @Override
    public void eliminarProducto(Long Id) {
        productosRepository.deleteById(Id);
        
    }

    
    
}
