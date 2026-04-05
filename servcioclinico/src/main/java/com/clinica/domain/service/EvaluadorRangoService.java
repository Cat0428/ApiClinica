package com.clinica.domain.service;

import org.springframework.stereotype.Service;

import com.clinica.domain.model.Examen;

@Service
public class EvaluadorRangoService {

    public boolean estaFueraDeRango(Examen examen) {

        String tipo = examen.getTipo();
        double valor = examen.getValor();

        if (tipo.equalsIgnoreCase("glucosa")) {
            return valor > 180;
        }

        if (tipo.equalsIgnoreCase("presion")) {
            return valor > 140;
        }

        return false;
    }
}