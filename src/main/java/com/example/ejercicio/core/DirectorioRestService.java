package com.example.ejercicio.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowedHeaders = "*")
@RestController
public class DirectorioRestService {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    private final Directorio directorio;

    public DirectorioRestService(Directorio directorio) {
        this.directorio = directorio;
    }

    @GetMapping("/personas")
    List<Persona> index() {
        return directorio.findPersonas();
    }

    @GetMapping("/personas/{identificacion}")
    Persona showByIndentificacion(@PathVariable String identificacion) {
        log.info("Buscando persona con identificacion " + identificacion);
        Persona persona = this.directorio.findPersonaByIdentificacion(identificacion);
        if (persona != null) {
            return persona;
        } else {
            throw new PersonaNotFoundException(identificacion);
        }
    }

    @PostMapping("/personas")
    Persona save(@RequestBody Persona persona) {
        log.info("Guardando persona con nombre " + persona.getNombre());
        return directorio.storePersona(persona);
    }

    @DeleteMapping("/personas/{identificacion}")
    void delete(@PathVariable String identificacion) {
        log.info("Elimiando persona con identificación: " + identificacion);
        directorio.deletePersonaByIdentificacion(identificacion);
    }

}
