package com.kgd.anticiberdron.model.Modelo_Biologico;

public class HLarva extends Hormiga {
    
    public HLarva() {
        super();
        this.estado = "Larva";
    }
    
    @Override
    public boolean comer(Alimento alimento) {
        return alimento instanceof ANectar;
    }
    
    public Hormiga evolucionar(Alimento alimento) {
        if (alimento instanceof ACarnivoro) {
            return new HSoldado();
        }
        return null;
    }
}
