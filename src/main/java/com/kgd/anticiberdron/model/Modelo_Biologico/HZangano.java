package com.kgd.anticiberdron.model.Modelo_Biologico;

public class HZangano extends Hormiga {
    
    public HZangano() {
        super();
        this.estado = "Zangano";
        this.sexo = "Macho";
    }
    
    @Override
    public boolean comer(Alimento alimento) {
        return alimento instanceof AOmnivoro;
    }
}
