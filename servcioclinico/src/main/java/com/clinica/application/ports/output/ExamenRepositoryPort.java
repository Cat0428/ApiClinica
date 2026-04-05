package com.clinica.application.ports.output;

import com.clinica.domain.model.Examen;

public interface ExamenRepositoryPort {

    void guardar(Examen examen);

}