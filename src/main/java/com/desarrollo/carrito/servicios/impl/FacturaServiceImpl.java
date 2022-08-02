package com.desarrollo.carrito.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.carrito.dto.FacturaDto;
import com.desarrollo.carrito.dto.mapper.FacturaMapper;
import com.desarrollo.carrito.entidades.Factura;
import com.desarrollo.carrito.excepciones.NoDataFoundException;
import com.desarrollo.carrito.repositorios.FacturaRepository;
import com.desarrollo.carrito.servicios.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {


    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    FacturaMapper facturaMapper;

    @Override
    public List<FacturaDto> listarFacturas() {
        List<FacturaDto> facturaDtos = new ArrayList<>();
        List<Factura> factura = (List<Factura>) facturaRepository.findAll();
        facturaDtos = facturaMapper.modelToDtos(factura);

        return facturaDtos;
    }

    @Override
    public FacturaDto buscarFactura(Long Id) {
        FacturaDto FacturaDto = new FacturaDto();

        if (facturaRepository.findById(Id).isPresent()) {
            FacturaDto = facturaMapper.modelToDto(facturaRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return FacturaDto;
    }

    @Override
    public FacturaDto guardarFactura(FacturaDto facturaDto) {
        if (facturaDto.getId() == 0) {
            Factura factura = new Factura();
            factura = facturaMapper.dtoToModel(facturaDto);
            factura = facturaRepository.save(factura);
            facturaDto = facturaMapper.modelToDto(factura);
        } else {
            Factura factura = facturaRepository.findById(facturaDto.getId()).get();
            factura = facturaMapper.dtoToModel(facturaDto);
            factura = facturaRepository.save(factura);
            facturaDto = facturaMapper.modelToDto(factura);

        }
        return null;
    }

    @Override
    public void eliminarFactura(Long Id) {
        facturaRepository.deleteById(Id);        
    }

    
}
