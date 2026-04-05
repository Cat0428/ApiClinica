package com.clinica.domain.model;

public class Examen {

    private String tipo;
    private double valor;

    public Examen(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}