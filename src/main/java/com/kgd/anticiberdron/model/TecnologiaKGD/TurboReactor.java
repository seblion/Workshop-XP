package com.kgd.anticiberdron.model.TecnologiaKGD;

public class TurboReactor {
    private boolean activo;
    private int consumoEnergia;
    
    public TurboReactor() {
        this.activo = false;
        this.consumoEnergia = 20; // Consumo de energía para volar
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public int getConsumoEnergia() {
        return consumoEnergia;
    }
    
    public void activar() {
        this.activo = true;
    }
    
    public void desactivar() {
        this.activo = false;
    }
    
    @Override
    public String toString() {
        return "TurboReactor{activo=" + activo + ", consumoEnergia=" + consumoEnergia + "%}";
    }
}
