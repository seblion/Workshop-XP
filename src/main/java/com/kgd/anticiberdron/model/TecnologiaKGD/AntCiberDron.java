package com.kgd.anticiberdron.model.TecnologiaKGD;

import com.kgd.anticiberdron.model.Modelo_Biologico.Hormiga;
import com.kgd.anticiberdron.model.pkAntCiberDronContract.IIA;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AntCiberDron implements IIA {
    private Hormiga piloto;
    private BBA bomba;
    private FuentePoder energia;
    private Metralleta pataDelanteraDerecha;
    private Laser pataDelanteraIzquierda;
    private TurboReactor espalda;
    
    private Map<String, String> expertosPersonas;
    private List<String> historialEntrenamientos; 
    
    public AntCiberDron() {
        this.bomba = new BBA();
        this.energia = new FuentePoder();
        this.pataDelanteraDerecha = new Metralleta();
        this.pataDelanteraIzquierda = new Laser();
        this.espalda = new TurboReactor();
        this.historialEntrenamientos = new ArrayList<>();
        
        this.expertosPersonas = new HashMap<>();
        this.expertosPersonas.put("Inglés", "Dr. John Smith (Experto en Inglés)");
        this.expertosPersonas.put("Español", "Dra. María García (Experta en Español)");
    }
    
    public Hormiga getPiloto() {
        return piloto;
    }
    
    public BBA getBomba() {
        return bomba;
    }
    
    public FuentePoder getEnergia() {
        return energia;
    }
    
    public Metralleta getPataDelanteraDerecha() {
        return pataDelanteraDerecha;
    }
    
    public Laser getPataDelanteraIzquierda() {
        return pataDelanteraIzquierda;
    }

    public Metralleta getExtremidadDer() {
        return pataDelanteraDerecha;
    }

    public Laser getExtremidadIzq() {
        return pataDelanteraIzquierda;
    }
    
    public TurboReactor getEspalda() {
        return espalda;
    }
    
    public void integrarHormiga(Hormiga h) {
        this.piloto = h;
    }

    public void volar() {
        if (espalda == null) {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║  [ERROR] No hay TurboReactor instalado                   ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            return;
        }
        
        int energiaRequerida = espalda.getConsumoEnergia();
        
        if (energia.getNivelEnergia() < energiaRequerida) {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║  [ERROR] Energía insuficiente para volar                 ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println("[!] Energía disponible: " + energia.getNivelEnergia() + "%");
            System.out.println("[!] Energía requerida: " + energiaRequerida + "%");
            System.out.println("[!] Por favor recargue la fuente de poder.");
            return;
        }
        
        if (energia.consumir(energiaRequerida)) {
            espalda.activar();
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║  [+] VUELO ACTIVADO - TurboReactor operando              ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println("[+] Energía consumida: " + energiaRequerida + "%");
            System.out.println("[+] Energía restante: " + energia.getNivelEnergia() + "%");
        }
    }
    
    public void dispararLaser() {
        if (pataDelanteraIzquierda == null) {
            System.out.println("[ERROR] No hay láser instalado en pata delantera izquierda");
            return;
        }
        
        int consumoLaser = 15; // Consumo de energía
        
        if (energia.getNivelEnergia() < consumoLaser) {
            System.out.println("[ERROR] Energía insuficiente para disparar láser");
            System.out.println("[!] Energía disponible: " + energia.getNivelEnergia() + "%");
            return;
        }
        
        int potenciaAjustada = pataDelanteraIzquierda.calcularPotencia(energia.getNivelEnergia());
        
        if (energia.consumir(consumoLaser)) {
            System.out.println("[+] Láser disparado desde pata delantera izquierda");
            System.out.println("[+] Potencia: " + potenciaAjustada);
            System.out.println("[+] Energía restante: " + energia.getNivelEnergia() + "%");
        }
    }
    
    public void dispararMetralleta() {
        if (pataDelanteraDerecha == null) {
            System.out.println("[ERROR] No hay metralleta instalada en pata delantera derecha");
            return;
        }
        
        int consumoMetralleta = 5; // Consumo de energía
        
        if (energia.getNivelEnergia() < consumoMetralleta) {
            System.out.println("[ERROR] Energía insuficiente para disparar metralleta");
            return;
        }
        
        if (pataDelanteraDerecha.getMunicion() <= 0) {
            System.out.println("[ERROR] Sin munición en metralleta");
            System.out.println("[!] Por favor recargue munición");
            return;
        }
        
        if (energia.consumir(consumoMetralleta)) {
            pataDelanteraDerecha.disparar();
            System.out.println("[+] Metralleta disparada desde pata delantera derecha");
            System.out.println("[+] Munición restante: " + pataDelanteraDerecha.getMunicion());
            System.out.println("[+] Energía restante: " + energia.getNivelEnergia() + "%");
        }
    }
    
    public boolean entrenarIdioma(String idioma, Hormiga hormiga) {
        if (!expertosPersonas.containsKey(idioma)) {
            return false;
        }
        
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expertoPersona = expertosPersonas.get(idioma);
        String registro = String.format("[%s] Idioma: %s | Entrenado por: %s | Piloto: %s (ID: %d) | Estado: COMPLETADO",
            ahora.format(formato), idioma, expertoPersona, hormiga.getEstado(), hormiga.getId());
        historialEntrenamientos.add(registro);
        
        return true;
    }
    
    public List<String> getHistorialEntrenamientos() {
        return new ArrayList<>(historialEntrenamientos);
    }
    
    public String getExpertoPorIdioma(String idioma) {
        return expertosPersonas.get(idioma);
    }
    
    /**
     * Reemplaza la fuente de poder actual por una nueva
     * Requiere asistencia del IIA (piloto integrado)
     * @return true si el reemplazo fue exitoso, false si no hay piloto IIA
     */
    public boolean reemplazarFuentePoder() {
        if (piloto == null) {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║  [ERROR] No hay piloto IIA integrado                     ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println("[!] Se requiere un piloto IIA para reemplazar la fuente de poder.");
            return false;
        }
        
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║  [+] Reemplazando fuente de poder...                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("[+] Piloto IIA: " + piloto.getEstado() + " (ID: " + piloto.getId() + ")");
        System.out.println("[+] Fuente de poder anterior: " + energia.getNivelEnergia() + "% de energía");
        
        this.energia = new FuentePoder();
        
        System.out.println("[+] Nueva fuente de poder instalada: " + energia.getNivelEnergia() + "% de energía");
        System.out.println("[✓] Reemplazo completado exitosamente con asistencia del IIA");
        return true;
    }
    
    @Override
    public boolean buscar(String tipoArsenal) {
        return bomba.validarObjetivo(tipoArsenal);
    }
    
    @Override
    public String toString() {
        return "AntCiberDron{" +
                "piloto=" + piloto +
                ", bomba=" + bomba +
                ", energia=" + energia +
                ", pataDelanteraDerecha=" + pataDelanteraDerecha +
                ", pataDelanteraIzquierda=" + pataDelanteraIzquierda +
                ", espalda=" + espalda +
                '}';
    }
}
