package com.desarrollo.carrito.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.carrito.dto.PersonaDto;
import com.desarrollo.carrito.dto.mapper.PersonaMapper;
import com.desarrollo.carrito.entidades.Personas;
import com.desarrollo.carrito.excepciones.NoDataFoundException;
import com.desarrollo.carrito.repositorios.PersonaRepository;
import com.desarrollo.carrito.servicios.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired(required = false)
    PersonaMapper personaMapper;

    @Override
    public List<PersonaDto> listarPersonas() {
        List<PersonaDto> personaDtos = new ArrayList<>();
        List<Personas> personas = (List<Personas>) personaRepository.findAll();
        personaDtos = personaMapper.modelToDtos(personas);
       
        return personaDtos;
    }

    @Override
    public PersonaDto buscarPersona(Long Id) {
        PersonaDto personaDto = new PersonaDto();
        if(personaRepository.findById(Id).isPresent()){

            personaDto = personaMapper.modelToDto(personaRepository.findById(Id).get());

        }
        else
        {
            throw new NoDataFoundException();
        }
        return personaDto;
    }

    @Override
    public PersonaDto guardarPersona(PersonaDto personaDto) {
        if (personaDto.getId() == null)
        {
           
            Personas persona = new Personas();
            persona = personaMapper.dtoToModel(personaDto);
            persona = personaRepository.save(persona);
            personaDto = personaMapper.modelToDto(persona);
            // persona.setNombres(personaDto.getNombres());
            // persona.setEmail(personaDto.getEmail());
            // persona.setApellidos(personaDto.getApellidos());
            // persona.setTelefono(personaDto.getTelefono());
            // persona = personaRepository.save(persona);
            // personaDto.setId(persona.getId());
            // personaDto.setNombres(persona.getNombres());
            // persona.setEmail(personaDto.getEmail());
            // persona.setApellidos(personaDto.getApellidos());
            // persona.setTelefono(personaDto.getTelefono());
        }
        else{
            Personas persona = personaRepository.findById(personaDto.getId()).get();
            
            persona = personaMapper.dtoToModel(personaDto);
            persona = personaRepository.save(persona);
            personaDto = personaMapper.modelToDto(persona);
            
            // persona.setNombres(personaDto.getNombres());
            // persona.setEmail(personaDto.getEmail());
            // persona.setApellidos(personaDto.getApellidos());
            // persona.setTelefono(personaDto.getTelefono());
            // persona = personaRepository.save(persona);
            // personaDto.setId(persona.getId());
            // personaDto.setNombres(persona.getNombres());
            // persona.setEmail(personaDto.getEmail());
            // persona.setApellidos(personaDto.getApellidos());
            // persona.setTelefono(personaDto.getTelefono());
        }
        return personaDto;
    }

    @Override
    public void eliminarPersona(Long Id) {
        personaRepository.deleteById(Id);
        
    }
    
}
