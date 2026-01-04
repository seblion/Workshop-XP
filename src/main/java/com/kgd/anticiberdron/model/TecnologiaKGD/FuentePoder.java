package com.kgd.anticiberdron.model.TecnologiaKGD;

public class FuentePoder {
    private int nivelEnergia;
    
    public FuentePoder() {
        this.nivelEnergia = 100;
    }
    
    public int getNivelEnergia() {
        return nivelEnergia;
    }
    
    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }
    
    public void recargar() {
        this.nivelEnergia = 100;
    }
    
    public boolean consumir(int cantidad) {
        if (nivelEnergia >= cantidad) {
            nivelEnergia -= cantidad;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "FuentePoder{nivelEnergia=" + nivelEnergia + "}";
    }
}
