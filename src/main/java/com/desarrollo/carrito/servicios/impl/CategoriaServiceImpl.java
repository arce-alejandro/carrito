package com.desarrollo.carrito.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.carrito.dto.CategoriasDto;
import com.desarrollo.carrito.dto.mapper.CategoriaMapper;
import com.desarrollo.carrito.entidades.Categorias;
import com.desarrollo.carrito.excepciones.NoDataFoundException;
import com.desarrollo.carrito.repositorios.CategoriasRepository;
import com.desarrollo.carrito.servicios.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriasDto> listarCategorias() {
        List<CategoriasDto> categoriasDtos = new ArrayList<>();
        List<Categorias> categorias = (List<Categorias>) categoriasRepository.findAll();
        categoriasDtos = categoriaMapper.modelToDtos(categorias);

        return categoriasDtos;
    }

    @Override
    public CategoriasDto buscarCategoria(Long Id) {
        CategoriasDto categoriasDto = new CategoriasDto();

        if (categoriasRepository.findById(Id).isPresent()) {
            categoriasDto = categoriaMapper.modelToDto(categoriasRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return categoriasDto;
    }

    @Override
    public CategoriasDto guardarCategoria(CategoriasDto categoriasDto) {
        if (categoriasDto.getId() == null) {
            Categorias categorias = new Categorias();
            categorias = categoriaMapper.dtoToModel(categoriasDto);
            categorias = categoriasRepository.save(categorias);
            categoriasDto = categoriaMapper.modelToDto(categorias);
        } else {
            Categorias categorias = categoriasRepository.findById(categoriasDto.getId()).get();
            categorias = categoriaMapper.dtoToModel(categoriasDto);
            categorias = categoriasRepository.save(categorias);
            categoriasDto = categoriaMapper.modelToDto(categorias);

        }
        return null;
    }

    @Override
    public void eliminarCategoria(Long Id) {

        categoriasRepository.deleteById(Id);
    }

}
