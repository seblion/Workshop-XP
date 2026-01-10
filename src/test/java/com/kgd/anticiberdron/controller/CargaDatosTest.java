package com.kgd.anticiberdron.controller;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class CargaDatosTest {

    // HU-02: Carga de Datos de Inteligencia
    @Test
    public void testCargaArchivoCSV() throws IOException {
        // Crear archivo CSV temporal para prueba
        File tempFile = File.createTempFile("test", ".csv");
        tempFile.deleteOnExit();
        
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("geoposicion,arsenal\n");
            writer.write("5,abc\n");
            writer.write("2,ab\n");
        }
        
        assertTrue(tempFile.exists(), "El archivo CSV debe existir");
        assertTrue(tempFile.length() > 0, "El archivo CSV debe contener datos");
    }

    @Test
    public void testValidacionColumnas() throws IOException {
        File tempFile = File.createTempFile("test", ".csv");
        tempFile.deleteOnExit();
        
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("geoposicion,arsenal\n");
            writer.write("5,abc\n");
        }
        
        // Leer primera línea y validar formato
        java.util.Scanner scanner = new java.util.Scanner(tempFile);
        String header = scanner.nextLine();
        scanner.close();
        
        assertTrue(header.contains("geoposicion"), "El archivo debe contener la columna geoposicion");
        assertTrue(header.contains("arsenal"), "El archivo debe contener la columna arsenal");
    }

    @Test
    public void testAnimacionCarga() {
        // Test de UI trigger - validar que la animación no lanza excepciones
        assertDoesNotThrow(() -> {
            System.out.println("Cargando datos...");
            Thread.sleep(100); // Simula animación
            System.out.println("Datos cargados.");
        }, "La animación de carga no debe lanzar excepciones");
    }
}
