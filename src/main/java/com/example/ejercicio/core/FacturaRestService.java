package com.example.ejercicio.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowedHeaders = "*")
@RestController
public class FacturaRestService {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    private final Ventas ventas;

    public FacturaRestService(Ventas ventas) {
        this.ventas = ventas;
    }

    @GetMapping("/personas/{id}/facturas")
    List<Factura> index(@PathVariable Long id) {
        log.info("obteniendo facturas");
        return this.ventas.findFacturasByPersona(id);
    }
    @PostMapping("/facturas")
    Factura save(@RequestBody Factura factura) {
        log.info("Guardando factura");
        return ventas.storeFactura(factura);
    }

}
