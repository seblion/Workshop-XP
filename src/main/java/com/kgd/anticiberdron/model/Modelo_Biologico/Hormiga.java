package com.kgd.anticiberdron.model.Modelo_Biologico;

import com.kgd.anticiberdron.model.pkAntCiberDronContract.IHormiga;

public abstract class Hormiga implements IHormiga {
    protected int id;
    protected String sexo;
    protected String estado;
    
    public Hormiga() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Hormiga{id=" + id + ", sexo='" + sexo + "', estado='" + estado + "'}";
    }
}
