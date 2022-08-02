package com.desarrollo.carrito.servicios;

import java.util.List;

import com.desarrollo.carrito.dto.PersonaDto;

public interface IPersonaService {
    List<PersonaDto> listarPersonas();
    PersonaDto buscarPersona(Long Id);
    PersonaDto guardarPersona(PersonaDto personaDto);
    void eliminarPersona(Long Id);
}
