package com.desarrollo.carrito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.carrito.dto.CategoriasDto;
import com.desarrollo.carrito.dto.ResponseDto;
import com.desarrollo.carrito.servicios.ICategoriaService;


@RestController
@RequestMapping("api/prueba/categorias")
public class CategoriaController {
    private ResponseDto responseDto;

    public CategoriaController() {
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso Realizado correctamente");
    }

    @Autowired
    ICategoriaService categoriaService;

    @GetMapping(path ="buscartodos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriaService.listarCategorias());

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id")Long id) {
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriaService.buscarCategoria(id));

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PostMapping( path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody CategoriasDto categoriasDto) {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(categoriaService.guardarCategoria(categoriasDto));

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") Long id){

        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        categoriaService.eliminarCategoria(id);
        responseDto.setData(null);

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
