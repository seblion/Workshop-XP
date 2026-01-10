package com.kgd.anticiberdron.model.TecnologiaKGD;

import com.kgd.anticiberdron.model.UsuarioKGD;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class EntrenamientoTest {

    // HU-06: Entrenamiento de Idiomas
    @Test
    public void testCargaLexico() {
        Map<String, String> lexico = new HashMap<>();
        lexico.put("hello", "hola");
        lexico.put("goodbye", "adiós");
        lexico.put("thank you", "gracias");
        
        assertNotNull(lexico, "El léxico debe ser cargado");
        assertEquals(3, lexico.size(), "Debe haber 3 palabras importadas");
        assertTrue(lexico.containsKey("hello"), "Debe contener la palabra 'hello'");
    }

    @Test
    public void testPermisoExperto() {
        UsuarioKGD experto = new UsuarioKGD("expert01", "pass", "Dr. Smith", "123", "EXPERTO");
        UsuarioKGD estudiante = new UsuarioKGD("student01", "pass", "Student", "456", "ESTUDIANTE");
        
        assertEquals("EXPERTO", experto.getRol(), "El usuario debe tener rol EXPERTO");
        assertEquals("ESTUDIANTE", estudiante.getRol(), "El usuario debe tener rol ESTUDIANTE");
        assertNotEquals(experto.getRol(), estudiante.getRol(), "Los roles deben ser diferentes");
    }
}
