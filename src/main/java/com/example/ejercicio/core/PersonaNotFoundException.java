package com.example.ejercicio.core;

public class PersonaNotFoundException extends RuntimeException {
    PersonaNotFoundException(String identificacion) {
        super("No se encontrĂ³ persona con identificacion: " + identificacion);
    }
}
