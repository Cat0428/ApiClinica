package com.clinica.adapters.output.persistence;

import org.springframework.stereotype.Component;

import com.clinica.application.ports.output.ExamenRepositoryPort;
import com.clinica.domain.model.Examen;

@Component
public class ExamenRepositoryMemory implements ExamenRepositoryPort {

    @Override
    public void guardar(Examen examen) {
        
        System.out.println("Examen guardado: " + examen.getTipo());
    }
}