package com.example.ejercicio.core;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class Directorio {

    private final PersonaRepository repository;

    public Directorio(PersonaRepository repository) {
        this.repository = repository;
    }

    public Persona findPersonaByIdentificacion(String identificacion) {
        return this.repository.findByIdentificacion(identificacion);
    }

    public List<Persona> findPersonas() {
        return this.repository.findAll();
    }

    public void deletePersonaByIdentificacion(String identificacion) {
        Persona persona = this.repository.findByIdentificacion(identificacion);
        this.repository.delete(persona);
    }

    public Persona storePersona(Persona persona) {
       return this.repository.save(persona);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}
