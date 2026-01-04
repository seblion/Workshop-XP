package com.kgd.anticiberdron.view;

import java.util.List;
import java.util.Scanner;
import com.kgd.anticiberdron.model.TecnologiaKGD.*;
import com.kgd.anticiberdron.model.Modelo_Biologico.*;

public class SistemaRusoView {
    private Scanner scanner;
    
    public SistemaRusoView(Scanner scanner) {
        this.scanner = scanner;
    }
    
    /**
     * Solicita credenciales al usuario
     */
    public String[] solicitarCredenciales() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        return new String[]{usuario, password};
    }
    
    public void mostrarMensajeAutenticacion() {
        System.out.println("KGD System - Authentication Required");
    }
    
    public void mostrarAccesoDenegado() {
        System.out.println("Acceso denegado. Número máximo de intentos excedido.");
    }
    
    public void mostrarCredencialesIncorrectas(int intentosRestantes) {
        System.out.println("Credenciales incorrectas. Intentos restantes: " + intentosRestantes);
    }
    
    
    public void mostrarBienvenida(String nombre) {
        System.out.println("\n[+] Autenticación exitosa.");
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║           BIENVENIDO AL SISTEMA KGD                    ║");
        System.out.println("║                                                        ║");
        String nombreCentrado = centrarTexto(nombre, 56);
        System.out.println("║" + nombreCentrado + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    
    private String centrarTexto(String texto, int ancho) {
        int espacios = (ancho - texto.length()) / 2;
        String resultado = "";
        for (int i = 0; i < espacios; i++) {
            resultado += " ";
        }
        resultado += texto;
        while (resultado.length() < ancho) {
            resultado += " ";
        }
        return resultado;
    }
    
    public void mostrarEquipo(String[] estudiantes) {
        System.out.println("\n[+] TEAM [1]: Retrievforge");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("    • Alumno " + (i + 1) + ": " + estudiantes[i]);
        }
    }
    
    public void mostrarErrorArchivoNoEncontrado(String fileName) {
        System.out.println("\n[!] ERROR: Archivo " + fileName + " no encontrado.");
        System.out.println("[!] Por favor, asegúrese de que el archivo existe en el directorio actual.");
    }
    
    public void mostrarCargaYListadoCoordenadas(String fileName, List<CoordenadaUK> coordenadas) {
        System.out.println("\n[+] Cargando datos desde " + fileName + "...");
        System.out.println("\n[+] COORDENADAS UCRANIANAS:");
        
        for (CoordenadaUK coord : coordenadas) {
            System.out.printf("%-10s ; %-8s ; %-8s ; %-10s ; %-8s ; %-8s ; %s\n",
                    coord.getGeoposicion(),
                    coord.getLunes(),
                    coord.getMartes(),
                    coord.getMiercoles(),
                    coord.getJueves(),
                    coord.getViernes(),
                    coord.getTipoArsenal());
            mostrarLoading();
        }
        
        System.out.println("\n[+] Coordenadas cargadas: " + coordenadas.size());
    }
    
    /**
     * Muestra una animación de carga
     */
    public void mostrarLoading() {
        String[] animation = { "\\", "|", "/", "-" };
        try {
            for (int i = 0; i <= 100; i += 5) {
                String animChar = animation[(i / 5) % animation.length];
                System.out.print("\r" + animChar + " " + i + "%");
                Thread.sleep(20);
            }
            System.out.print("\r");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Muestra el menú principal del sistema KGD
     */
    public void mostrarMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║           SISTEMA KGD - MENÚ PRINCIPAL                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("  1. Misión de Ataque (AntCiberDron/Bomba)");
        System.out.println("  2. Hormiguero Virtual (Gestión de Hormigas)");
        System.out.println("  3. Laboratorio / Entrenamiento");
        System.out.println("  4. Salir");
        System.out.print("\n  Seleccione una opción: ");
    }
    
    public void mostrarMensajeMenu(String tipoMensaje) {
        switch (tipoMensaje) {
            case "salir":
                System.out.println("\n[+] Saliendo del sistema KGD...");
                break;
            case "opcion_invalida":
                System.out.println("\n[!] Opción no válida. Intente nuevamente.");
                break;
            case "numero_invalido":
                System.out.println("\n[!] Por favor ingrese un número válido.");
                break;
        }
    }

    /**
     * Muestra la misión de ataque con las coordenadas cargadas
     */
    public void mostrarMisionAtaque(List<CoordenadaUK> coordenadas) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              MISIÓN DE ATAQUE ACTIVADA                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        if (coordenadas.isEmpty()) {
            System.out.println("[!] No hay coordenadas cargadas.");
            return;
        }
        
        System.out.println("\nCOORDENADAS UCRANIANAS A DESTRUIR:");
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println(String.format("%-15s | %-15s | %-10s", "Geoposición", "Tipo Arsenal", "Acción"));
        System.out.println("─────────────────────────────────────────────────────────");
        
        for (CoordenadaUK coord : coordenadas) {
            String accion = coord.isAccion() ? "true" : "false";
            System.out.println(String.format("%-15s | %-15s | %-10s", 
                coord.getGeoposicion(), 
                coord.getTipoArsenal(), 
                accion));
        }
        
        System.out.println("─────────────────────────────────────────────────────────");
    }
    
    /**
     * Muestra el menú del hormiguero virtual
     */
    public void mostrarMenuHormiguero() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              HORMIGUERO VIRTUAL KGD                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("  1. Crear nueva hormiga (Larva)");
        System.out.println("  2. Alimentar hormiga");
        System.out.println("  3. Ver estado de las hormigas");
        System.out.println("  4. Eliminar hormiga");
        System.out.println("  5. Volver al menú principal");
        System.out.print("\n  Seleccione una opción: ");
    }
    
    public void mostrarMensajeHormiguero(String tipo, Object... params) {
        switch (tipo) {
            case "creada":
                System.out.println("\n[+] Nueva larva creada con ID: " + params[0]);
                break;
            case "no_hay":
                System.out.println("\n[!] No hay hormigas en el hormiguero.");
                break;
            case "no_encontrada":
                System.out.println("\n[!] Hormiga no encontrada.");
                break;
            case "seleccionada":
                Hormiga h = (Hormiga) params[0];
                System.out.println("\n[+] Hormiga seleccionada: " + h.getEstado() + " (ID: " + h.getId() + ")");
                if (h instanceof HLarva) {
                    System.out.println("[+] Las LARVAS se mantienen con Néctar o evolucionan a SOLDADO con Carnívoro");
                } else if (h instanceof HSoldado) {
                    System.out.println("[+] Los SOLDADOS solo pueden alimentarse con: Carnívoro ");
                }
                break;
            case "menu_alimentos":
                System.out.println("\nTipos de alimento disponibles :");
                System.out.println("  1. Néctar");
                System.out.println("  2. Carnívoro");
                System.out.print("\nSeleccione el alimento: ");
                break;
            case "evolucion_exitosa":
                Hormiga hormiga = (Hormiga) params[0];
                String tipoAlimento = (String) params[1];
                System.out.println("\n[+] ¡La larva ha evolucionado a " + hormiga.getEstado() + "!");
                System.out.println("[+] A partir de ahora solo puede comer " + tipoAlimento);
                break;
            case "larva_mantiene":
                System.out.println("\n[+] La larva comió néctar. Se mantiene como larva (aún puede evolucionar con Carnívoro).");
                break;
            case "larva_no_comio":
                System.out.println("\n[!] La larva no puede comer ese alimento para sobrevivir.");
                break;
            case "alimentacion_exitosa":
                Hormiga horm = (Hormiga) params[0];
                String tipo_alimento = (String) params[1];
                System.out.println("\n[+] ¡Alimentación exitosa!");
                System.out.println("[+] La hormiga " + horm.getEstado() + " (ID: " + horm.getId() + ") ha comido " + tipo_alimento);
                break;
            case "error_alimento":
                Hormiga hor = (Hormiga) params[0];
                String tipoReq = (String) params[1];
                String tipoProp = (String) params[2];
                System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
                System.out.println("║                         ¡ERROR CRÍTICO!                          ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════╝");
                System.out.println("\n[✗] EXCEPCIÓN: Tipo de alimento incorrecto");
                System.out.println("[✗] La hormiga " + hor.getEstado() + " (ID: " + hor.getId() + ") solo puede alimentarse con: " + tipoReq);
                System.out.println("[✗] Alimento proporcionado: " + tipoProp);
                System.out.println("[✗] La hormiga NO ha sido alimentada.");
                System.out.println("\n[!] Por favor, seleccione el alimento correcto.");
                break;
            case "eliminada":
                Hormiga hormigaElim = (Hormiga) params[0];
                int total = (int) params[1];
                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║              HORMIGA ELIMINADA                           ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.println("\n[+] Hormiga " + hormigaElim.getEstado() + " (ID: " + hormigaElim.getId() + ") eliminada exitosamente.");
                System.out.println("[+] Total de hormigas restantes: " + total);
                break;
            case "eliminacion_cancelada":
                System.out.println("\n[+] Eliminación cancelada.");
                break;
            case "operacion_cancelada":
                System.out.println("\n[+] Operación cancelada.");
                break;
        }
    }
    
    public void mostrarTablaHormigas(String contexto, List<Hormiga> hormiguero) {
        if (hormiguero.isEmpty()) {
            mostrarMensajeHormiguero("no_hay");
            return;
        }
        
        switch (contexto) {
            case "alimentar":
                System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║              HORMIGAS DISPONIBLES PARA ALIMENTAR                       ║");
                System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
                System.out.println(String.format("\n%-5s | %-15s | %-10s | %-30s", "ID", "Estado", "Sexo", "Alimento Permitido"));
                System.out.println("────────────────────────────────────────────────────────────────────────");
                for (Hormiga h : hormiguero) {
                    String alimentoPermitido = (h instanceof HLarva) ? "Néctar (mantiene) / Carnívoro (evoluciona a Soldado)" : "Carnívoro";
                    System.out.println(String.format("%-5d | %-15s | %-10s | %-30s", h.getId(), h.getEstado(), h.getSexo(), alimentoPermitido));
                }
                System.out.println("────────────────────────────────────────────────────────────────────────");
                System.out.println("\n=== ALIMENTAR HORMIGA ===");
                System.out.print("Ingrese el ID de la hormiga: ");
                break;
            case "ver":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║              ESTADO DEL HORMIGUERO                     ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println(String.format("\n%-5s | %-15s | %-10s", "ID", "Estado", "Sexo"));
                System.out.println("─────────────────────────────────────────────────────");
                for (Hormiga h : hormiguero) {
                    System.out.println(String.format("%-5d | %-15s | %-10s", h.getId(), h.getEstado(), h.getSexo()));
                }
                System.out.println("\n[+] Total de hormigas: " + hormiguero.size());
                break;
            case "eliminar":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║              ELIMINAR HORMIGA                          ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println(String.format("\n%-5s | %-15s | %-10s", "ID", "Estado", "Sexo"));
                System.out.println("─────────────────────────────────────────────────────");
                for (Hormiga h : hormiguero) {
                    System.out.println(String.format("%-5d | %-15s | %-10s", h.getId(), h.getEstado(), h.getSexo()));
                }
                System.out.println("\n=== ELIMINAR HORMIGA ===");
                System.out.print("Ingrese el ID de la hormiga a eliminar: ");
                break;
        }
    }
    
    public void solicitarConfirmacion(String tipo, Hormiga hormiga) {
        if (tipo.equals("eliminar")) {
            System.out.println("\n[!] ¿Está seguro de eliminar la hormiga " + hormiga.getEstado() + " (ID: " + hormiga.getId() + ")?");
            System.out.print("Escriba 'SI' para confirmar: ");
        } else if (tipo.equals("piloto")) {
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║                    ¡ADVERTENCIA!                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println("\n[!] Esta hormiga está actualmente integrada al AntCiberDron como piloto.");
            System.out.print("[!] ¿Desea eliminarla de todos modos? (SI/NO): ");
        }
    }

    /**
     * Muestra el laboratorio
     */
    public void mostrarMensajeLaboratorio(String tipo, Object... params) {
        switch (tipo) {
            case "no_hay_hormigas":
                System.out.println("\n[!] No hay hormigas en el hormiguero.");
                System.out.println("[!] Debe crear hormigas primero en el Hormiguero Virtual.");
                break;
            case "tabla_entrenamiento":
                List<Hormiga> hormiguero = (List<Hormiga>) params[0];
                System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║         HORMIGAS DISPONIBLES PARA ENTRENAMIENTO                        ║");
                System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
                System.out.println(String.format("\n%-5s | %-15s | %-10s | %-25s", "ID", "Estado", "Sexo", "Aptitud"));
                System.out.println("────────────────────────────────────────────────────────────────────────");
                for (Hormiga h : hormiguero) {
                    String aptitud = (h instanceof HLarva) ? "NO APTA (debe evolucionar)" : "APTA para entrenamiento";
                    System.out.println(String.format("%-5d | %-15s | %-10s | %-25s", h.getId(), h.getEstado(), h.getSexo(), aptitud));
                }
                System.out.println("────────────────────────────────────────────────────────────────────────");
                System.out.print("\nIngrese el ID de la hormiga para trabajar en el laboratorio: ");
                break;
            case "larva_no_apta":
                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║                    ¡ADVERTENCIA!                         ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.println("\n[!] La hormiga seleccionada es una LARVA.");
                System.out.println("[!] Las larvas NO son aptas para el entrenamiento.");
                System.out.println("[!] Debe alimentarla primero para que evolucione.");
                break;
            case "hormiga_seleccionada":
                Hormiga h = (Hormiga) params[0];
                System.out.println("\n[+] Hormiga #" + h.getId() + " - " + h.getEstado() + " seleccionada.");
                break;
        }
    }
    
    public void mostrarMenuLaboratorio(Hormiga hormiga) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              LABORATORIO KGD                           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("  HORMIGA SELECCIONADA: #" + hormiga.getId() + " - " + hormiga.getEstado() + " (" + hormiga.getSexo() + ")");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("  1. Entrenar idioma de esta hormiga");
        System.out.println("  2. Integrar esta hormiga al AntCiberDron");
        System.out.println("  3. Recargar fuente de poder del AntCiberDron");
        System.out.println("  4. Reemplazar fuente de poder del AntCiberDron");
        System.out.println("  5. Estado del AntCiberDron");
        System.out.println("  6. Prueba de vuelo");
        System.out.println("  7. Disparar láser (Pata Izquierda)");
        System.out.println("  8. Disparar metralleta (Pata Derecha)");
        System.out.println("  9. Recargar munición");
        System.out.println("  10. Ver historial de entrenamientos");
        System.out.println("  11. Volver al menú principal");
        System.out.print("\n  Seleccione una opción: ");
    }
    
    /**
     * Muestra el entrenamiento de idiomas
     */
    public void mostrarMensajeEntrenamiento(String tipo, Object... params) {
        switch (tipo) {
            case "titulo":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║         ENTRENAMIENTO DE IDIOMA - HORMIGA              ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                break;
            case "piloto":
                Hormiga h = (Hormiga) params[0];
                System.out.println("\n[+] Hormiga piloto: #" + h.getId() + " - " + h.getEstado() + " (" + h.getSexo() + ")");
                break;
            case "menu_idiomas":
                String expertoIngles = (String) params[0];
                String expertoEspanol = (String) params[1];
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║       IDIOMAS DISPONIBLES Y EXPERTOS ASIGNADOS         ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println("\n  1. Inglés    [Experto: " + expertoIngles + "]");
                System.out.println("  2. Español   [Experto: " + expertoEspanol + "]");
                System.out.print("\nSeleccione el idioma a entrenar: ");
                break;
            case "conectando_experto":
                String idioma = (String) params[0];
                System.out.println("\n[+] Conectando con experto en " + idioma + "...");
                break;
            case "experto_listo":
                String experto = (String) params[0];
                System.out.println("[+] " + experto + " está listo para entrenar.");
                break;
            case "iniciando":
                String idiomaInicio = (String) params[0];
                System.out.println("[+] Iniciando sesión de entrenamiento de " + idiomaInicio + "...");
                break;
            case "exitoso":
                String idiomaExito = (String) params[0];
                String expertoExito = (String) params[1];
                Hormiga hormigaExito = (Hormiga) params[2];
                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║              ¡ENTRENAMIENTO EXITOSO!                     ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.println("\n[+] El AntCiberDron ha sido entrenado en " + idiomaExito);
                System.out.println("[+] Entrenador: " + expertoExito);
                System.out.println("[+] Piloto durante el entrenamiento: " + hormigaExito.getEstado() + " (ID: " + hormigaExito.getId() + ")");
                System.out.println("[+] Sesión registrada exitosamente con fecha y hora");
                break;
            case "ultima_sesion":
                String sesion = (String) params[0];
                System.out.println("\n[+] Última sesión registrada:");
                System.out.println("    " + sesion);
                break;
            case "error_registro":
                System.out.println("\n[!] Error al registrar el entrenamiento.");
                break;
        }
    }
    
    // ==================== INTEGRACIÓN Y OPERACIONES DRON ====================
    
    public void mostrarMensajeDron(String tipo, Object... params) {
        switch (tipo) {
            case "titulo_integracion":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║       INTEGRAR HORMIGA AL ANTICIBERDRON                ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                break;
            case "integrando":
                Hormiga h = (Hormiga) params[0];
                System.out.println("\n[+] Integrando Hormiga #" + h.getId() + " - " + h.getEstado() + " al AntCiberDron...");
                break;
            case "integracion_exitosa":
                Hormiga hormiga = (Hormiga) params[0];
                System.out.println("\n[+] ¡Integración exitosa!");
                System.out.println("[+] Hormiga " + hormiga.getEstado() + " (ID: " + hormiga.getId() + ") ahora es el piloto del AntCiberDron.");
                break;
            case "recarga_energia":
                int nivelAnterior = (int) params[0];
                Hormiga piloto = (Hormiga) params[1];
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║       RECARGA DE FUENTE DE PODER                       ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println("[+] Piloto IIA: " + piloto.getEstado() + " (ID: " + piloto.getId() + ")");
                System.out.println("[+] Energía recargada: " + nivelAnterior + "% → 100%");
                System.out.println("[✓] Recarga completada exitosamente");
                break;
            case "error_sin_piloto_recarga":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║  [ERROR] No se puede recargar la fuente de poder       ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println("[!] Se requiere una hormiga integrada al AntCiberDron");
                System.out.println("[!] Por favor, integre primero una hormiga como piloto IIA");
                break;
            case "titulo_reemplazo_fuente":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║       REEMPLAZO DE FUENTE DE PODER                     ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                break;
            case "reemplazo_exitoso":
                System.out.println("[✓] Fuente de poder reemplazada exitosamente");
                System.out.println("[✓] Nueva fuente instalada con 100% de energía");
                break;
            case "reemplazo_fallido":
                System.out.println("[X] No se pudo reemplazar la fuente de poder");
                System.out.println("[!] Se requiere un piloto IIA integrado");
                break;
            case "recarga_municion":
                int municionAnterior = (int) params[0];
                int municionNueva = (int) params[1];
                Hormiga pilotoMunicion = (Hormiga) params[2];
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║       RECARGA DE MUNICIÓN                              ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println("[+] Piloto IIA: " + pilotoMunicion.getEstado() + " (ID: " + pilotoMunicion.getId() + ")");
                System.out.println("[+] Munición recargada: " + municionAnterior + " → " + municionNueva);
                System.out.println("[✓] Recarga completada exitosamente");
                break;
            case "error_sin_piloto_municion":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║  [ERROR] No se puede recargar la munición              ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                System.out.println("[!] Se requiere una hormiga integrada al AntCiberDron");
                System.out.println("[!] Por favor, integre primero una hormiga como piloto IIA");
                break;
            case "no_metralleta":
                System.out.println("\n=== RECARGA DE MUNICIÓN ===");
                System.out.println("[!] No hay metralleta instalada.");
                break;
        }
    }

    /**
     * Muestra el estado actual del AntCiberDron
     */
    public void mostrarEstadoDron(AntCiberDron dron) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║           ESTADO DEL ANTICIBERDRON                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("\n  • Piloto: " + (dron.getPiloto() != null ? 
            dron.getPiloto().getEstado() + " (ID: " + dron.getPiloto().getId() + ")" : "Ninguno"));
        System.out.println("  • Energía: " + dron.getEnergia().getNivelEnergia() + "%");
        System.out.println("  • Bomba: " + (dron.getBomba() != null ? "Operativa" : "No disponible"));
        
        if (dron.getPataDelanteraIzquierda() != null) {
            int potenciaActual = dron.getPataDelanteraIzquierda().calcularPotencia(dron.getEnergia().getNivelEnergia());
            System.out.println("  • Pata Delantera Izquierda (Láser): Operativo");
            System.out.println("    - Potencia Base: " + dron.getPataDelanteraIzquierda().getPotencia());
            System.out.println("    - Potencia Actual: " + potenciaActual + " (según energía disponible)");
        } else {
            System.out.println("  • Pata Delantera Izquierda (Láser): No disponible");
        }

        if (dron.getPataDelanteraDerecha() != null) {
            System.out.println("  • Pata Delantera Derecha (Metralleta): Operativa");
            System.out.println("    - Munición: " + dron.getPataDelanteraDerecha().getMunicion() + 
                "/" + dron.getPataDelanteraDerecha().getCapacidadMaxima());
        } else {
            System.out.println("  • Pata Delantera Derecha (Metralleta): No disponible");
        }
        
        if (dron.getEspalda() != null) {
            System.out.println("  • TurboReactor: " + (dron.getEspalda().isActivo() ? "Activo" : "Inactivo"));
            System.out.println("    - Consumo de energía: " + dron.getEspalda().getConsumoEnergia() + "%");
        } else {
            System.out.println("  • TurboReactor: No disponible");
        }
    }
    
    /**
     * Muestra  las operaciones del dron
     */
    
    public void mostrarMensajeOperacion(String tipo, Object... params) {
        switch (tipo) {
            case "titulo_vuelo":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║              PRUEBA DE VUELO                           ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                break;
            case "titulo_laser":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║         DISPARAR LÁSER (PATA IZQUIERDA)                ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                break;
            case "titulo_metralleta":
                System.out.println("\n╔════════════════════════════════════════════════════════╗");
                System.out.println("║       DISPARAR METRALLETA (PATA DERECHA)               ║");
                System.out.println("╚════════════════════════════════════════════════════════╝");
                break;
            case "error_no_piloto_vuelo":
                System.out.println("\n╔══════════════════════════════════════════════════════════╗");
                System.out.println("║                    ¡ERROR CRÍTICO!                       ║");
                System.out.println("╚══════════════════════════════════════════════════════════╝");
                System.out.println("\n[✗] No hay piloto integrado al AntCiberDron.");
                System.out.println("[✗] Debe integrar una hormiga primero (Opción 2).");
                System.out.println("[✗] Imposible realizar prueba de vuelo sin piloto.");
                break;
            case "error_no_piloto_disparo":
                System.out.println("\n[✗] ERROR: No hay piloto integrado al AntCiberDron.");
                System.out.println("[✗] Debe integrar una hormiga primero (Opción 2).");
                System.out.println("[✗] Imposible disparar sin piloto.");
                break;
            case "piloto_detectado":
                Hormiga piloto = (Hormiga) params[0];
                System.out.println("\n[+] Piloto detectado: " + piloto.getEstado() + " (ID: " + piloto.getId() + ")");
                System.out.println("[+] Iniciando secuencia de vuelo...");
                break;
            case "piloto_disparo":
                Hormiga p = (Hormiga) params[0];
                System.out.println("\n[+] Piloto: " + p.getEstado() + " (ID: " + p.getId() + ")");
                break;
        }
    }

    /**
     * Muestra el historial de entrenamientos
     */
    public void mostrarHistorialEntrenamientos(List<String> historial) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         HISTORIAL DE SESIONES DE ENTRENAMIENTO                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        
        if (historial.isEmpty()) {
            System.out.println("\n[!] No hay sesiones de entrenamiento registradas.");
            System.out.println("[!] Complete entrenamientos para ver el historial.");
            return;
        }
        
        System.out.println("\n[+] Total de sesiones registradas: " + historial.size());
        System.out.println("\n════════════════════════════════════════════════════════════════════════");
        
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
        
        System.out.println("════════════════════════════════════════════════════════════════════════");
        System.out.println("\n[+] Todas las sesiones incluyen fecha, hora, idioma y entrenador.");
    }
}
