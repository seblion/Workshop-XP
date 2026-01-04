package com.kgd.anticiberdron.model;

/**
 * Clase que representa un usuario del sistema KGD
 * Puede ser: Profesor, Estudiante o Experto
 */
public class UsuarioKGD {
    private String usuario;   
    private String password;  
    private String nombre;    
    private String cedula;    
    private String rol;       

    public UsuarioKGD(String usuario, String password, String nombre, String cedula, String rol) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.cedula = cedula;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Valida si la contraseña proporcionada es correcta
     */
    public boolean validarPassword(String pass) {
        return this.password.equals(pass);
    }

    /**
     * Verifica si el usuario es profesor
     */
    public boolean esProfesor() {
        return "PROFESOR".equals(rol);
    }

    /**
     * Verifica si el usuario es estudiante
     */
    public boolean esEstudiante() {
        return "ESTUDIANTE".equals(rol);
    }

    /**
     * Verifica si el usuario es experto
     */
    public boolean esExperto() {
        return "EXPERTO".equals(rol);
    }

    @Override
    public String toString() {
        return "UsuarioKGD{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
