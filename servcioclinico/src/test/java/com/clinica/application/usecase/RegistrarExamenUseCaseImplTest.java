package com.clinica.application.usecase;

import com.clinica.application.ports.output.AlertaRepositoryPort;
import com.clinica.application.ports.output.ExamenRepositoryPort;
import com.clinica.domain.service.EvaluadorRangoService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RegistrarExamenUseCaseImplTest {

    @Test
    void casoExitoso_deberiaGuardarExamen() {

        ExamenRepositoryPort examenRepo = mock(ExamenRepositoryPort.class);
        AlertaRepositoryPort alertaRepo = mock(AlertaRepositoryPort.class);
        EvaluadorRangoService evaluador = new EvaluadorRangoService();

        RegistrarExamenUseCaseImpl useCase =
                new RegistrarExamenUseCaseImpl(examenRepo, alertaRepo, evaluador);

        useCase.registrarExamen("glucosa", 100);

        verify(examenRepo).guardar(any());
    }

    @Test
    void casoInvalido_deberiaGenerarAlerta() {

        ExamenRepositoryPort examenRepo = mock(ExamenRepositoryPort.class);
        AlertaRepositoryPort alertaRepo = mock(AlertaRepositoryPort.class);
        EvaluadorRangoService evaluador = new EvaluadorRangoService();

        RegistrarExamenUseCaseImpl useCase =
                new RegistrarExamenUseCaseImpl(examenRepo, alertaRepo, evaluador);

        useCase.registrarExamen("glucosa", 250);

        verify(alertaRepo).guardar(any());
    }

    @Test
    void comportamientoEsperado_noDebeGenerarAlerta() {

        ExamenRepositoryPort examenRepo = mock(ExamenRepositoryPort.class);
        AlertaRepositoryPort alertaRepo = mock(AlertaRepositoryPort.class);
        EvaluadorRangoService evaluador = new EvaluadorRangoService();

        RegistrarExamenUseCaseImpl useCase =
                new RegistrarExamenUseCaseImpl(examenRepo, alertaRepo, evaluador);

        useCase.registrarExamen("glucosa", 90);

        verify(alertaRepo, never()).guardar(any());
    }
}