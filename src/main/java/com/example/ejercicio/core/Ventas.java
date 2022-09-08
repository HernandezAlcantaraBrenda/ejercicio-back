package com.example.ejercicio.core;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Ventas {

    private final FacturaRepository facturaRepository;

    public Ventas(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> findFacturasByPersona(Long id) {
        return this.facturaRepository.findAll()
                .stream()
                .filter(factura -> factura.getPersona().getId().equals(id))
                .collect(Collectors.toList());
    }

    public Factura storeFactura(Factura factura) {
        return this.facturaRepository.save(factura);
    }
}
