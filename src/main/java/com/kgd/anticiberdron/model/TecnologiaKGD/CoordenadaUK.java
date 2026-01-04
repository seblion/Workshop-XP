package com.kgd.anticiberdron.model.TecnologiaKGD;

public class CoordenadaUK {
    private String geoposicion;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;
    private String tipoArsenal;
    private boolean accion;

    public CoordenadaUK(String geoposicion, String lunes, String martes, String miercoles, String jueves,
            String viernes, String tipoArsenal) {
        this.geoposicion = geoposicion;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.tipoArsenal = tipoArsenal;
    }

    public String getGeoposicion() {
        return geoposicion;
    }

    public String getLunes() {
        return lunes;
    }

    public String getMartes() {
        return martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public String getTipoArsenal() {
        return tipoArsenal;
    }

    public boolean isAccion() {
        return accion;
    }

    public void setAccion(boolean accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return geoposicion + " | " + lunes + " | " + martes + " | " + miercoles + " | " + jueves + " | " + viernes
                + " | " + tipoArsenal;
    }
}
