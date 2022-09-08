package com.example.ejercicio.core;

public class PersonaNotFoundException extends RuntimeException {
    PersonaNotFoundException(String identificacion) {
        super("No se encontró persona con identificacion: " + identificacion);
    }
}
