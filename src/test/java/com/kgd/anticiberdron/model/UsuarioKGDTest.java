package com.kgd.anticiberdron.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioKGDTest {

    @Test
    public void testUsuarioCreation() {
        UsuarioKGD usuario = new UsuarioKGD("testUser", "password123", "Test User", "1234567890", "ESTUDIANTE");
        
        assertEquals("testUser", usuario.getUsuario());
        assertEquals("password123", usuario.getPassword());
        assertEquals("Test User", usuario.getNombre());
        assertEquals("1234567890", usuario.getCedula());
        assertEquals("ESTUDIANTE", usuario.getRol());
    }
    
    @Test
    public void testSetters() {
        UsuarioKGD usuario = new UsuarioKGD("user", "pass", "name", "id", "role");
        
        usuario.setUsuario("newUser");
        assertEquals("newUser", usuario.getUsuario());
    }

    @Test
    public void testValidarPasswordIncorrecto() {
        UsuarioKGD usuario = new UsuarioKGD("user", "correctPass", "name", "id", "role");
        assertFalse(usuario.validarPassword("wrongPass"), "Debe retornar false para contraseña incorrecta");
    }

    @Test
    public void testAutenticacionExitosa() {
        UsuarioKGD usuario = new UsuarioKGD("admin", "password123", "Administrador", "1234567890", "ADMINISTRADOR");
        assertTrue(usuario.validarPassword("password123"), "Debe retornar true para contraseña correcta");
    }

    @Test
    public void testMostrarFichaEquipo() {
        UsuarioKGD usuario = new UsuarioKGD("dev01", "pass123", "Developer One", "0987654321", "DESARROLLADOR");
        
        assertNotNull(usuario.getNombre(), "El nombre no debe ser null");
        assertNotNull(usuario.getCedula(), "La cédula no debe ser null");
        assertNotNull(usuario.getRol(), "El rol no debe ser null");
        assertEquals("Developer One", usuario.getNombre());
        assertEquals("0987654321", usuario.getCedula());
        assertEquals("DESARROLLADOR", usuario.getRol());
    }
}
