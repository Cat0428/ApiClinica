package com.clinica.application.ports.output;

import com.clinica.domain.model.Alerta;

public interface AlertaRepositoryPort {

    void guardar(Alerta alerta);
}