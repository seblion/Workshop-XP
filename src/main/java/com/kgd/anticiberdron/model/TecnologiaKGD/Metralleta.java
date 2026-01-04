package com.kgd.anticiberdron.model.TecnologiaKGD;

public class Metralleta {
    private int municion;
    private int capacidadMaxima;
    
    public Metralleta() {
        this.capacidadMaxima = 100;
        this.municion = capacidadMaxima;
    }
    
    public int getMunicion() {
        return municion;
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public void recargarMunicion() {
        this.municion = capacidadMaxima;
    }
    
    public boolean disparar() {
        if (municion > 0) {
            municion--;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Metralleta{municion=" + municion + "/" + capacidadMaxima + "}";
    }
}
