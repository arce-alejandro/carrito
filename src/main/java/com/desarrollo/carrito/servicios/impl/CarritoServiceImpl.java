package com.desarrollo.carrito.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.carrito.dto.CarritoDto;
import com.desarrollo.carrito.dto.mapper.CarritoMapper;
import com.desarrollo.carrito.excepciones.NoDataFoundException;
import com.desarrollo.carrito.repositorios.CarritoRepository;
import com.desarrollo.carrito.servicios.ICarritoService;
import com.desarrollo.carrito.entidades.Carrito;

@Service
public class CarritoServiceImpl implements ICarritoService {


    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    CarritoMapper carritoMapper;    

   

    @Override
    public List<CarritoDto> listarCarrito() {
        List<CarritoDto> carritoDtos = new ArrayList<>();
        List<Carrito> carrito = (List<Carrito>) carritoRepository.findAll();
        carritoDtos = carritoMapper.modelToDtos(carrito);

        return carritoDtos;
    }

    @Override
    public CarritoDto buscarCarrito(Long Id) {
        CarritoDto carritoDto = new CarritoDto();

        if (carritoRepository.findById(Id).isPresent()) {
            carritoDto = carritoMapper.modelToDto(carritoRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return carritoDto;
    }

    @Override
    public CarritoDto guardarCarrito(CarritoDto carritoDto) {
        if (carritoDto.getId() == 0) {
            Carrito carrito = new Carrito();
            carrito = carritoMapper.dtoToModel(carritoDto);
            carrito = carritoRepository.save(carrito);
            carritoDto = carritoMapper.modelToDto(carrito);
        } else {
            Carrito carrito = carritoRepository.findById(carritoDto.getId()).get();
            carrito = carritoMapper.dtoToModel(carritoDto);
            carrito = carritoRepository.save(carrito);
            carritoDto = carritoMapper.modelToDto(carrito);

        }

        return null;
    }

    @Override
    public void eliminarCarrito(Long Id) {
        carritoRepository.deleteById(Id);
        
    }
    
}
