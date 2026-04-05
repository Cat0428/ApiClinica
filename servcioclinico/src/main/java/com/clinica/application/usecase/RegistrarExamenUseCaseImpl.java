package com.clinica.application.usecase;

import org.springframework.stereotype.Service;

import com.clinica.application.ports.input.RegistrarExamenUseCase;
import com.clinica.application.ports.output.AlertaRepositoryPort;
import com.clinica.application.ports.output.ExamenRepositoryPort;
import com.clinica.domain.model.Alerta;
import com.clinica.domain.model.Examen;
import com.clinica.domain.service.EvaluadorRangoService;

@Service
public class RegistrarExamenUseCaseImpl implements RegistrarExamenUseCase {

    private final ExamenRepositoryPort examenRepository;
    private final AlertaRepositoryPort alertaRepository;
    private final EvaluadorRangoService evaluador;

    public RegistrarExamenUseCaseImpl(
            ExamenRepositoryPort examenRepository,
            AlertaRepositoryPort alertaRepository,
            EvaluadorRangoService evaluador) {

        this.examenRepository = examenRepository;
        this.alertaRepository = alertaRepository;
        this.evaluador = evaluador;
    }

    @Override
    public void registrarExamen(String tipo, double valor) {

        Examen examen = new Examen(tipo, valor);

        examenRepository.guardar(examen);

        if (evaluador.estaFueraDeRango(examen)) {
            Alerta alerta = new Alerta("Valor fuera de rango");
            alertaRepository.guardar(alerta);
        }
    }
}