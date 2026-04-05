package com.clinica.adapters.input.rest;

import com.clinica.application.ports.input.RegistrarExamenUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    private final RegistrarExamenUseCase registrarExamenUseCase;

    public ExamenController(RegistrarExamenUseCase registrarExamenUseCase) {
        this.registrarExamenUseCase = registrarExamenUseCase;
    }

    @PostMapping
    public void registrarExamen(@RequestBody ExamenRequest request) {
        registrarExamenUseCase.registrarExamen(request.getTipo(), request.getValor());
    }
}