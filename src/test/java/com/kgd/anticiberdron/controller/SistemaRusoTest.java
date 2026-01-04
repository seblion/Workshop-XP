package com.kgd.anticiberdron.controller;

import com.kgd.anticiberdron.model.TecnologiaKGD.BBA;
import com.kgd.anticiberdron.view.SistemaRusoView;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaRusoTest {

    /**
     * Valida que el autómata BBA acepte los tipos de arsenal generados
     * basados en los últimos dígitos de las cédulas del equipo de desarrollo (KGB)
     * y todos los posibles dígitos de Geoposición (0-9).
     * 
     * Lógica de validación (según tabla de Geoposición):
     * - 0, 1 -> a+
     * - 2, 9 -> ab*
     * - 3, 8 -> abc
     * - 4, 7 -> abcd*
     * - 5, 6 -> abcdt+
     */
    @Test
    public void testValidacionAutomataPorCedulasEquipo() throws Exception {
        BBA bba = new BBA();

        // Casos de prueba según diferentes tipos de arsenal
        // Basados en los patrones que el autómata debe aceptar
        String[][] testCases = {
            {"a", "Dígito 0 o 1"},          // a+ con n=1
            {"aa", "Dígito 0 o 1"},         // a+ con n=2
            {"ab", "Dígito 2 o 9"},         // ab* con n=2
            {"abb", "Dígito 2 o 9"},        // ab* con n>2
            {"abc", "Dígito 3 o 8"},        // abc
            {"abcd", "Dígito 4 o 7"},       // abcd* con n=4
            {"abcdd", "Dígito 4 o 7"},      // abcd* con n>4
            {"abcdt", "Dígito 5 o 6"},      // abcdt+ con n=1 t
            {"abcdtt", "Dígito 5 o 6"}      // abcdt+ con n>1 t
        };

        for (String[] testCase : testCases) {
            String cadenaArsenal = testCase[0];
            String descripcion = testCase[1];
            
            boolean resultado = bba.validarObjetivo(cadenaArsenal);

            // Debug info para verificar en consola
            System.out.println("Test Arsenal: " + cadenaArsenal + " (" + descripcion + ") | ¿Destruir?: " + resultado);

            assertTrue(resultado,
                    "El autómata BBA debería aceptar el arsenal: " + cadenaArsenal + " (" + descripcion + ")");
        }
    }

    @Test
    public void testRechazoCadenasInvalidas() {
        BBA bba = new BBA();
        String[] invalidos = {
            "x",            // Caracter inválido inicio
            "ax",           // Caracter inválido después de a
            "abx",          // Caracter inválido después de ab
            "abcde",        // 'e' no es válido después de abcd
            "abcdttx",      // 'x' interrumpe la secuencia de t
            "",             // Cadena vacía
            null            // Null
        };
        
        for (String s : invalidos) {
            assertFalse(bba.validarObjetivo(s), "El autómata debería rechazar la cadena inválida: " + s);
        }
    }

    /**
     * Valida que el sistema maneje correctamente los intentos fallidos de autenticación.
     * Verifica que se permitan 3 intentos y se muestre el conteo regresivo correcto.
     */
    @Test
    public void testAutenticacionFallidaYReintentos() throws Exception {
        // 1. Crear Mock de la Vista
        MockSistemaRusoView mockVista = new MockSistemaRusoView();
        
        // 2. Crear instancia de SistemaRuso
        SistemaRuso sistema = new SistemaRuso();
        
        // 3. Inyectar el Mock en el campo 'vista' de la instancia
        Field vistaField = SistemaRuso.class.getDeclaredField("vista");
        vistaField.setAccessible(true);
        vistaField.set(sistema, mockVista);
        
        // 4. Invocar el método privado 'autenticarUsuario' en la instancia
        Method authMethod = SistemaRuso.class.getDeclaredMethod("autenticarUsuario");
        authMethod.setAccessible(true);
        
        boolean resultado = (boolean) authMethod.invoke(sistema);
        
        // 5. Validaciones
        assertFalse(resultado, "La autenticación debería fallar después de 3 intentos incorrectos");
        assertEquals(3, mockVista.llamadasIncorrectas, "Debería haber 3 intentos fallidos");
        
        // Verificar que se mostraron los mensajes de intentos restantes correctamente: 2, 1, 0
        assertEquals(2, mockVista.intentosRestantesReportados[0], "Primer fallo debería mostrar 2 intentos restantes");
        assertEquals(1, mockVista.intentosRestantesReportados[1], "Segundo fallo debería mostrar 1 intento restante");
        assertEquals(0, mockVista.intentosRestantesReportados[2], "Tercer fallo debería mostrar 0 intentos restantes");
    }
    
    // Clase Mock interna para simular la vista
    static class MockSistemaRusoView extends SistemaRusoView {
        int llamadasIncorrectas = 0;
        int[] intentosRestantesReportados = new int[3];

        public MockSistemaRusoView() {
            super(new Scanner(""));
        }

        @Override
        public String[] solicitarCredenciales() {
            // Retorna credenciales que no existen en el sistema
            return new String[]{"usuario_inexistente", "pass_incorrecto"};
        }

        @Override
        public void mostrarCredencialesIncorrectas(int intentosRestantes) {
            if (llamadasIncorrectas < 3) {
                intentosRestantesReportados[llamadasIncorrectas] = intentosRestantes;
            }
            llamadasIncorrectas++;
        }
        
        @Override
        public void mostrarMensajeAutenticacion() {}
        @Override
        public void mostrarAccesoDenegado() {}
    }
}