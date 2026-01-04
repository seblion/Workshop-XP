package com.kgd.anticiberdron.model.Modelo_Biologico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HLarvaTest {

    @Test
    public void testComerNectar() {
        HLarva larva = new HLarva();
        ANectar nectar = new ANectar();
        
        assertTrue(larva.comer(nectar), "La larva debería comer néctar");
    }

    @Test
    public void testEvolucionarASoldado() {
        HLarva larva = new HLarva();
        ACarnivoro carne = new ACarnivoro();
        
        Hormiga evolucionada = larva.evolucionar(carne);
        
        assertNotNull(evolucionada, "La larva debería evolucionar al comer carne");
        assertTrue(evolucionada instanceof HSoldado, "La larva debería evolucionar a HSoldado");
    }
    
    @Test
    public void testNoEvolucionarConNectar() {
        HLarva larva = new HLarva();
        ANectar nectar = new ANectar();
        
        Hormiga evolucionada = larva.evolucionar(nectar);
        
        assertNull(evolucionada, "La larva no debería evolucionar con néctar");
    }
}
