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

import com.desarrollo.carrito.dto.PersonaDto;
import com.desarrollo.carrito.dto.ResponseDto;
import com.desarrollo.carrito.servicios.IPersonaService;

@RestController
@RequestMapping("api/prueba/personas")
public class PersonaController {
    private ResponseDto responseDto;

    public PersonaController() {
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso Realizado correctamente");
    }

    @Autowired
    IPersonaService personaService;

    @GetMapping(path ="buscartodos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(personaService.listarPersonas());

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id")Long id) {
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(personaService.buscarPersona(id));

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PostMapping( path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody PersonaDto personaDto) {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(personaService.guardarPersona(personaDto));

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") Long id){

        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        personaService.eliminarPersona(id);
        responseDto.setData(null);

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

}
