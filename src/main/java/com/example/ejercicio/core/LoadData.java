package com.example.ejercicio.core;

import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Configuration
public class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(PersonaRepository repository, FacturaRepository facturaRepository) {

        return args -> {
            log.info(
                    "Creando persona " + repository.save(
                            new Persona("Brenda", "Hernandez", "Alcantara", "32")
                    )
            );
            log.info(
                    "Creando factura" + facturaRepository.save(
                            new Factura(repository.findByIdentificacion("32"), new Date() , 45.34f)
                    )
            );
        };
    }

}
