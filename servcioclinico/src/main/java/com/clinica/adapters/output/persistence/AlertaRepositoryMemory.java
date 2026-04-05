package com.clinica.adapters.output.persistence;

import org.springframework.stereotype.Component;

import com.clinica.application.ports.output.AlertaRepositoryPort;
import com.clinica.domain.model.Alerta;

@Component
public class AlertaRepositoryMemory implements AlertaRepositoryPort {

    @Override
    public void guardar(Alerta alerta) {
        System.out.println("Alerta guardada: " + alerta.getMensaje());
    }
}