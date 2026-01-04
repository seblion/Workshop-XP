package com.kgd.anticiberdron.model.TecnologiaKGD;

public class Laser {
    private int potenciaBase;
    
    public Laser() {
        this.potenciaBase = 100;
    }
    
    public Laser(int potencia) {
        this.potenciaBase = potencia;
    }
    
    public int getPotencia() {
        return potenciaBase;
    }
    
    public void setPotencia(int potencia) {
        this.potenciaBase = potencia;
    }
    
    public int calcularPotencia(int nivelEnergia) {
        if (nivelEnergia <= 0) {
            return 0;
        }
        // La potencia efectiva es proporcional a la energía disponible
        // Si hay 100% de energía, potencia = potenciaBase
        // Si hay 50% de energía, potencia = potenciaBase * 0.5
        return (int) (potenciaBase * (nivelEnergia / 100.0));
    }
    
    @Override
    public String toString() {
        return "Laser{potenciaBase=" + potenciaBase + "}";
    }
}
