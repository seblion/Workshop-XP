package com.kgd.anticiberdron.model.TecnologiaKGD;

import com.kgd.anticiberdron.model.Modelo_Biologico.HSoldado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AntCiberDronTest {

    // HU-05: Interfaz de Combate
    @Test
    public void testAsociacionExtremidades() {
        AntCiberDron dron = new AntCiberDron();
        
        assertNotNull(dron.getExtremidadDer(), "La extremidad derecha debe estar asociada");
        assertNotNull(dron.getExtremidadIzq(), "La extremidad izquierda debe estar asociada");
        assertTrue(dron.getExtremidadDer() instanceof Metralleta, "La extremidad derecha debe ser una Metralleta");
        assertTrue(dron.getExtremidadIzq() instanceof Laser, "La extremidad izquierda debe ser un Laser");
    }

    @Test
    public void testConsumoEnergia() {
        AntCiberDron dron = new AntCiberDron();
        int energiaInicial = dron.getEnergia().getNivelEnergia();
        
        dron.volar();
        
        int energiaFinal = dron.getEnergia().getNivelEnergia();
        assertTrue(energiaFinal < energiaInicial, "El vuelo debe reducir la batería");
        assertEquals(20, energiaInicial - energiaFinal, "El vuelo debe consumir 20% de energía");
    }

    // HU-07: Hormiguero Virtual
    @Test
    public void testCrearHormiga() {
        AntCiberDron dron = new AntCiberDron();
        HSoldado soldado = new HSoldado();
        
        dron.integrarHormiga(soldado);
        
        assertNotNull(dron.getPiloto(), "La hormiga debe ser creada e integrada");
        assertTrue(dron.getPiloto() instanceof HSoldado, "La hormiga debe ser del tipo HSoldado");
    }

    @Test
    public void testAsignarMision() {
        AntCiberDron dron = new AntCiberDron();
        HSoldado soldado = new HSoldado();
        soldado.setId(1);
        soldado.setEstado("Activo");
        
        dron.integrarHormiga(soldado);
        
        // Verificar que el piloto está integrado correctamente
        assertNotNull(dron.getPiloto(), "La hormiga piloto debe existir");
        assertEquals(1, dron.getPiloto().getId(), "El ID del piloto debe ser 1");
        assertEquals("Activo", dron.getPiloto().getEstado(), "El estado del piloto debe ser Activo");
        
        // Verificar que puede buscar arsenal (misión principal)
        boolean resultado = dron.buscar("abc");
        assertTrue(resultado, "El dron debe poder buscar y validar objetivos");
    }
}
