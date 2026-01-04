package com.kgd.anticiberdron.model.Modelo_Biologico;

public abstract class Alimento {
    protected String tipo;

    public Alimento() {
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
