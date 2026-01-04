package com.kgd.anticiberdron.model.Modelo_Biologico;

public class HRastreadora extends Hormiga {
    
    public HRastreadora() {
        super();
        this.estado = "Rastreadora";
        this.sexo = "Hembra";
    }
    
    @Override
    public boolean comer(Alimento alimento) {
        return alimento instanceof AHervivoro;
    }
}
