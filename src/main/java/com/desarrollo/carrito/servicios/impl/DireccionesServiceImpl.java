package com.desarrollo.carrito.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.carrito.dto.DireccionesDto;
import com.desarrollo.carrito.dto.mapper.DireccionesMapper;
import com.desarrollo.carrito.entidades.Direcciones;
import com.desarrollo.carrito.excepciones.NoDataFoundException;
import com.desarrollo.carrito.repositorios.DireccionesRepository;
import com.desarrollo.carrito.servicios.IDireccionesService;

@Service
public class DireccionesServiceImpl implements IDireccionesService {


    @Autowired
    DireccionesRepository direccionesRepository;

    @Autowired
    DireccionesMapper direccionesMapper;

    @Override
    public List<DireccionesDto> listarDirecciones() {
        List<DireccionesDto> direccionesDtos = new ArrayList<>();
        List<Direcciones> direcciones = (List<Direcciones>) direccionesRepository.findAll();
        direccionesDtos = direccionesMapper.modelToDtos(direcciones);

        return direccionesDtos;
    }

    @Override
    public DireccionesDto buscarDirecciones(Long Id) {
        DireccionesDto direccionesDto = new DireccionesDto();

        if (direccionesRepository.findById(Id).isPresent()) {
            direccionesDto = direccionesMapper.modelToDto(direccionesRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return direccionesDto;


    }

    @Override
    public DireccionesDto guardarDireccion(DireccionesDto direccionesDto) {
        if (direccionesDto.getId() == 0) {
            Direcciones direcciones = new Direcciones();
            direcciones = direccionesMapper.dtoToModel(direccionesDto);
            direcciones = direccionesRepository.save(direcciones);
            direccionesDto = direccionesMapper.modelToDto(direcciones);
        } else {
            Direcciones direcciones = direccionesRepository.findById(direccionesDto.getId()).get();
            direcciones = direccionesMapper.dtoToModel(direccionesDto);
            direcciones = direccionesRepository.save(direcciones);
            direccionesDto = direccionesMapper.modelToDto(direcciones);

        }
        return null;
    }

    @Override
    public void eliminarDireccion(Long Id) {
        direccionesRepository.deleteById(Id);        
    }
    
}
