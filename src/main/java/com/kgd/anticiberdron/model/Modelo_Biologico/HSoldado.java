package com.kgd.anticiberdron.model.Modelo_Biologico;

public class HSoldado extends Hormiga {
    
    public HSoldado() {
        super();
        this.estado = "Soldado";
        this.sexo = "Hembra";
    }
    
    @Override
    public boolean comer(Alimento alimento) {
        return alimento instanceof ACarnivoro;
    }
}
