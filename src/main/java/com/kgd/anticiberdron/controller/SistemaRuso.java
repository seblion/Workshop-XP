package com.kgd.anticiberdron.controller;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kgd.anticiberdron.model.TecnologiaKGD.*;
import com.kgd.anticiberdron.model.Modelo_Biologico.*;
import com.kgd.anticiberdron.model.UsuarioKGD;
import com.kgd.anticiberdron.view.SistemaRusoView;

public class SistemaRuso {
    private Map<String, UsuarioKGD> usuarios;
    private List<CoordenadaUK> coordenadasCargadas;
    private List<Hormiga> hormiguero;
    private AntCiberDron dron;
    private SistemaRusoView vista;
    private Scanner scanner;
    private UsuarioKGD usuarioActual;
    
    private static final int MAX_ATTEMPTS = 3;
    
    public SistemaRuso() {
        this.usuarios = new HashMap<>();
        this.coordenadasCargadas = new ArrayList<>();
        this.hormiguero = new ArrayList<>();
        this.dron = new AntCiberDron();
        this.scanner = new Scanner(System.in);
        this.vista = new SistemaRusoView(scanner);
        
        this.usuarios.put("patmic", new UsuarioKGD(
            "patmic", "123", "Patricio Pacha", "9999999999", "PROFESOR"
        ));
        this.usuarios.put("Alexis", new UsuarioKGD(
            "Alexis", "1727061101", "Alexis Sotomayor", "1727061101", "ESTUDIANTE"
        ));
        this.usuarios.put("Sebastian", new UsuarioKGD(
            "Sebastian", "1750269407", "Sebastian Leon", "1750269407", "ESTUDIANTE"
        ));
        this.usuarios.put("Evelin", new UsuarioKGD(
            "Evelin", "1726725326", "Evelin Rocha", "1726725326", "ESTUDIANTE"
        ));
        this.usuarios.put("Angel", new UsuarioKGD(
            "Angel", "1005387319", "Angel Anguaya", "1005387319", "ESTUDIANTE"
        ));
        this.usuarios.put("Eduardo", new UsuarioKGD(
            "Eduardo", "1722208525", "Eduardo Arcos", "1722208525", "ESTUDIANTE"
        ));
        
        // Expertos en idiomas
        this.usuarios.put("expert_en", new UsuarioKGD(
            "expert_en", "english123", "John Smith", "9999999999", "EXPERTO-INGLÉS"
        ));
        this.usuarios.put("expert_es", new UsuarioKGD(
            "expert_es", "spanish123", "María García", "9999999999", "EXPERTO-ESPAÑOL"
        ));
    }

    static class Student {
        String name;
        String cedula;

        public Student(String cedula, String name) {
            this.cedula = cedula;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        SistemaRuso sistema = new SistemaRuso();
        sistema.ejecutar();
    }
    
    /**
     * Método principal que ejecuta el sistema
     */
    public void ejecutar() {
        vista.mostrarMensajeAutenticacion();
        if (!autenticarUsuario()) {
            vista.mostrarAccesoDenegado();
            return;
        }

        Student[] students = {
                new Student("1727061101", "Alexis Sotomayor"),
                new Student("1750269407", "Sebastian Leon"),
                new Student("1726725326", "Evelin Rocha"),
                new Student("1005387319", "Angel  Anguaya"),
                new Student("1722208525", "Eduardo Arcos")
        };

        String[] estudiantesInfo = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            estudiantesInfo[i] = students[i].cedula + " | " + students[i].name;
        }
        
        if (usuarioActual != null) {
            vista.mostrarBienvenida(usuarioActual.getNombre());
        }
        vista.mostrarEquipo(estudiantesInfo);

        String fileName = "Grupo01.csv";
        File csvFile = new File(fileName);
        
        if (!csvFile.exists()) {
            vista.mostrarErrorArchivoNoEncontrado(fileName);
            return;
        }
        
        coordenadasCargadas = readCoord(fileName);
        vista.mostrarCargaYListadoCoordenadas(fileName, coordenadasCargadas);
        mostrarMenuPrincipal();
        
        scanner.close();
    }

    private boolean autenticarUsuario() {
        int intentos = 0;
        while (intentos < MAX_ATTEMPTS) {
            String[] credenciales = vista.solicitarCredenciales();
            String u = credenciales[0];
            String p = credenciales[1];

            if (usuarios.containsKey(u)) {
                UsuarioKGD usuario = usuarios.get(u);
                if (usuario.validarPassword(p)) {
                    usuarioActual = usuario;
                    return true;
                }
            }
            
            intentos++;
            vista.mostrarCredencialesIncorrectas(MAX_ATTEMPTS - intentos);
        }
        
        return false;
    }

    /**
     * Lee las coordenadas desde un archivo CSV
     * @param fileName Nombre del archivo a leer
     * @return Lista de CoordenadaUK
     */
    public List<CoordenadaUK> readCoord(String fileName) {
        List<CoordenadaUK> coordenadas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] datos = line.split(";", -1);
                if (datos.length >= 1) { 
                    String geoposicion = datos.length > 0 ? datos[0].trim() : "";
                    String lunes = datos.length > 1 ? datos[1].trim() : "";
                    String martes = datos.length > 2 ? datos[2].trim() : "";
                    String miercoles = datos.length > 3 ? datos[3].trim() : "";
                    String jueves = datos.length > 4 ? datos[4].trim() : "";
                    String viernes = datos.length > 5 ? datos[5].trim() : "";
                    String tipoArsenal = datos.length > 6 ? datos[6].trim() : "";
                    
                    CoordenadaUK coord = new CoordenadaUK(
                        geoposicion, lunes, martes, miercoles, jueves, viernes, tipoArsenal
                    );
                    coordenadas.add(coord);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
        return coordenadas;
    }
    
    /**
     * Crea un archivo de lista con las coordenadas proporcionadas
     * @param coordenadas Lista de coordenadas a escribir
     */
    public void crearArchivoLista(List<CoordenadaUK> coordenadas) {
        String fileName = "coordenadas_lista.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=== LISTA DE COORDENADAS ===\n\n");
            for (CoordenadaUK coord : coordenadas) {
                writer.write(coord.toString());
                writer.newLine();
            }
            System.out.println("Archivo de lista creado: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creando archivo de lista: " + e.getMessage());
        }
    }
    
    /**
     * Muestra el menú principal y gestiona las opciones
     */
    private void mostrarMenuPrincipal() {
        boolean salir = false;
        
        while (!salir) {
            vista.mostrarMenuPrincipal();
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        misionAtaque();
                        break;
                    case 2:
                        hormigueroVirtual();
                        break;
                    case 3:
                        laboratorio();
                        break;
                    case 4:
                        vista.mostrarMensajeMenu("salir");
                        salir = true;
                        break;
                    default:
                        vista.mostrarMensajeMenu("opcion_invalida");
                }
            } catch (NumberFormatException e) {
                vista.mostrarMensajeMenu("numero_invalido");
            }
        }
    }

    /**
     * Misión de Ataque - Funcionalidad AntCiberDron/Bomba
     */
    private void misionAtaque() {
        if (coordenadasCargadas.isEmpty()) {
            vista.mostrarMisionAtaque(coordenadasCargadas);
            return;
        }

        for (CoordenadaUK coord : coordenadasCargadas) {
            boolean debeExplotar = dron.buscar(coord.getTipoArsenal());
            coord.setAccion(debeExplotar);
        }
        
        vista.mostrarMisionAtaque(coordenadasCargadas);
    }

    /**
     * Hormiguero Virtual - Gestión de Hormigas
     */
    private void hormigueroVirtual() {
        boolean volver = false;
        
        while (!volver) {
            vista.mostrarMenuHormiguero();
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        crearHormiga();
                        break;
                    case 2:
                        alimentarHormiga();
                        break;
                    case 3:
                        verHormigas();
                        break;
                    case 4:
                        eliminarHormiga();
                        break;
                    case 5:
                        volver = true;
                        break;
                    default:
                        vista.mostrarMensajeMenu("opcion_invalida");
                }
            } catch (NumberFormatException e) {
                vista.mostrarMensajeMenu("numero_invalido");
            }
        }
    }

    /**
     * Crea una nueva hormiga larva
     */
    private void crearHormiga() {
        HLarva larva = new HLarva();
        larva.setId(hormiguero.size() + 1);
        larva.setSexo("Hembra");
        hormiguero.add(larva);
        vista.mostrarMensajeHormiguero("creada", larva.getId());
    }

    /**
     * Alimenta una hormiga para que evolucione o se mantenga viva
     */
    private void alimentarHormiga() {
        if (hormiguero.isEmpty()) {
            vista.mostrarMensajeHormiguero("no_hay");
            return;
        }
        
        vista.mostrarTablaHormigas("alimentar", hormiguero);
        
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Hormiga hormiga = null;
            int index = -1;
            
            for (int i = 0; i < hormiguero.size(); i++) {
                if (hormiguero.get(i).getId() == id) {
                    hormiga = hormiguero.get(i);
                    index = i;
                    break;
                }
            }
            
            if (hormiga == null) {
                vista.mostrarMensajeHormiguero("no_encontrada");
                return;
            }

            vista.mostrarMensajeHormiguero("seleccionada", hormiga);
            vista.mostrarMensajeHormiguero("menu_alimentos");
            
            int tipoAlimento = Integer.parseInt(scanner.nextLine());
            Alimento alimento = null;
            
            switch (tipoAlimento) {
                case 1:
                    alimento = new ANectar();
                    break;
                case 2:
                    alimento = new ACarnivoro();
                    break;
                default:
                    vista.mostrarMensajeMenu("opcion_invalida");
                    return;
            }
            
            if (hormiga instanceof HLarva) {
                HLarva larva = (HLarva) hormiga;
                
                Hormiga hormigaEvolucionada = larva.evolucionar(alimento);
                if (hormigaEvolucionada != null) {
                    hormigaEvolucionada.setId(larva.getId());
                    hormiguero.set(index, hormigaEvolucionada);
                    vista.mostrarMensajeHormiguero("evolucion_exitosa", hormigaEvolucionada, alimento.getTipo());
                } else {
                    if (larva.comer(alimento)) {
                        vista.mostrarMensajeHormiguero("larva_mantiene");
                    } else {
                        vista.mostrarMensajeHormiguero("larva_no_comio");
                    }
                }
            } else {
                boolean puedeAlimentar = hormiga.comer(alimento);
                
                if (puedeAlimentar) {
                    vista.mostrarMensajeHormiguero("alimentacion_exitosa", hormiga, alimento.getTipo());
                } else {
                    String tipoRequerido = "Carnívoro";
                    vista.mostrarMensajeHormiguero("error_alimento", hormiga, tipoRequerido, alimento.getTipo());
                    
                    throw new IllegalArgumentException(
                        "Tipo de alimento incorrecto. " + hormiga.getEstado() + 
                        " requiere " + tipoRequerido + ", pero se proporcionó " + alimento.getTipo());
                }
            }
            
        } catch (NumberFormatException e) {
            vista.mostrarMensajeMenu("numero_invalido");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Muestra el estado de todas las hormigas
     */
    private void verHormigas() {
        vista.mostrarTablaHormigas("ver", hormiguero);
    }

    /**
     * Elimina una hormiga del hormiguero
     */
    private void eliminarHormiga() {
        if (hormiguero.isEmpty()) {
            vista.mostrarMensajeHormiguero("no_hay");
            return;
        }
        
        vista.mostrarTablaHormigas("eliminar", hormiguero);
        
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Hormiga hormigaAEliminar = null;
            
            for (Hormiga h : hormiguero) {
                if (h.getId() == id) {
                    hormigaAEliminar = h;
                    break;
                }
            }
            
            if (hormigaAEliminar == null) {
                vista.mostrarMensajeHormiguero("no_encontrada");
                return;
            }
            
            vista.solicitarConfirmacion("eliminar", hormigaAEliminar);
            String confirmacion = scanner.nextLine().trim();
            
            if (confirmacion.equalsIgnoreCase("SI")) {
                if (dron.getPiloto() != null && dron.getPiloto().getId() == id) {
                    vista.solicitarConfirmacion("piloto", hormigaAEliminar);
                    String confirmacionFinal = scanner.nextLine().trim();
                    
                    if (!confirmacionFinal.equalsIgnoreCase("SI")) {
                        vista.mostrarMensajeHormiguero("operacion_cancelada");
                        return;
                    }
                }
                
                hormiguero.remove(hormigaAEliminar);
                vista.mostrarMensajeHormiguero("eliminada", hormigaAEliminar, hormiguero.size());
            } else {
                vista.mostrarMensajeHormiguero("eliminacion_cancelada");
            }
            
        } catch (NumberFormatException e) {
            vista.mostrarMensajeMenu("numero_invalido");
        }
    }

    /**
     * Laboratorio - Entrenamiento y recarga
     */
    private void laboratorio() {
        if (hormiguero.isEmpty()) {
            vista.mostrarMensajeLaboratorio("no_hay_hormigas");
            System.out.println("\nPresione ENTER para continuar...");
            scanner.nextLine();
            return;
        }
        
        vista.mostrarMensajeLaboratorio("tabla_entrenamiento", hormiguero);
        
        Hormiga hormigaSeleccionada = null;
        try {
            int id = Integer.parseInt(scanner.nextLine());
            
            for (Hormiga h : hormiguero) {
                if (h.getId() == id) {
                    hormigaSeleccionada = h;
                    break;
                }
            }
            
            if (hormigaSeleccionada == null) {
                vista.mostrarMensajeHormiguero("no_encontrada");
                return;
            }
            
            if (hormigaSeleccionada instanceof HLarva) {
                vista.mostrarMensajeLaboratorio("larva_no_apta");
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
                return;
            }
            
            vista.mostrarMensajeLaboratorio("hormiga_seleccionada", hormigaSeleccionada);
            
        } catch (NumberFormatException e) {
            vista.mostrarMensajeMenu("numero_invalido");
            return;
        }
        
        boolean volver = false;
        
        while (!volver) {
            vista.mostrarMenuLaboratorio(hormigaSeleccionada);
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        entrenarIdiomaHormiga(hormigaSeleccionada);
                        break;
                    case 2:
                        integrarHormigaSeleccionadaDron(hormigaSeleccionada);
                        break;
                    case 3:
                        recargarEnergia();
                        break;
                    case 4:
                        reemplazarFuentePoder();
                        break;
                    case 5:
                        estadoDron();
                        break;
                    case 6:
                        pruebaVuelo();
                        break;
                    case 7:
                        dispararLaser();
                        break;
                    case 8:
                        dispararMetralleta();
                        break;
                    case 9:
                        recargarMunicion();
                        break;
                    case 10:
                        verHistorialEntrenamientos();
                        break;
                    case 11:
                        volver = true;
                        break;
                    default:
                        vista.mostrarMensajeMenu("opcion_invalida");
                }
            } catch (NumberFormatException e) {
                vista.mostrarMensajeMenu("numero_invalido");
            }
        }
    }

    /**
     * Entrena el idioma de una hormiga específica ya seleccionada
     */
    private void entrenarIdiomaHormiga(Hormiga hormiga) {
        vista.mostrarMensajeEntrenamiento("titulo");
        vista.mostrarMensajeEntrenamiento("piloto", hormiga);
        
        vista.mostrarMensajeEntrenamiento("menu_idiomas", dron.getExpertoPorIdioma("Inglés"), dron.getExpertoPorIdioma("Español"));
        
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            String idioma = "";
            
            switch (opcion) {
                case 1:
                    idioma = "Inglés";
                    break;
                case 2:
                    idioma = "Español";
                    break;
                default:
                    vista.mostrarMensajeMenu("opcion_invalida");
                    return;
            }

            vista.mostrarMensajeEntrenamiento("conectando_experto", idioma);
            vista.mostrarLoading();
            vista.mostrarMensajeEntrenamiento("experto_listo", dron.getExpertoPorIdioma(idioma));
            vista.mostrarMensajeEntrenamiento("iniciando", idioma);
            vista.mostrarLoading();
            
            if (dron.entrenarIdioma(idioma, hormiga)) {
                vista.mostrarMensajeEntrenamiento("exitoso", idioma, dron.getExpertoPorIdioma(idioma), hormiga);
                List<String> historial = dron.getHistorialEntrenamientos();
                if (!historial.isEmpty()) {
                    vista.mostrarMensajeEntrenamiento("ultima_sesion", historial.get(historial.size() - 1));
                }
            } else {
                vista.mostrarMensajeEntrenamiento("error_registro");
            }
            
        } catch (NumberFormatException e) {
            vista.mostrarMensajeMenu("numero_invalido");
        }
    }
    
    /**
     * Integra la hormiga seleccionada al AntCiberDron
     */
    private void integrarHormigaSeleccionadaDron(Hormiga hormiga) {
        vista.mostrarMensajeDron("titulo_integracion");
        vista.mostrarMensajeDron("integrando", hormiga);
        vista.mostrarLoading();
        dron.integrarHormiga(hormiga);
        vista.mostrarMensajeDron("integracion_exitosa", hormiga);
    }

    /**
     * Recarga la fuente de poder del AntCiberDron
     * Requiere que haya una hormiga integrada al AntCiberDron
     */
    private void recargarEnergia() {
        if (dron.getPiloto() == null) {
            vista.mostrarMensajeDron("error_sin_piloto_recarga");
            return;
        }
        
        int nivelAnterior = dron.getEnergia().getNivelEnergia();
        dron.getEnergia().recargar();
        vista.mostrarMensajeDron("recarga_energia", nivelAnterior, dron.getPiloto());
    }
    
    /**
     * Reemplaza la fuente de poder del AntCiberDron
     * Requiere asistencia del IIA (piloto integrado)
     */
    private void reemplazarFuentePoder() {
        vista.mostrarMensajeDron("titulo_reemplazo_fuente");
        boolean exitoso = dron.reemplazarFuentePoder();
        if (exitoso) {
            vista.mostrarMensajeDron("reemplazo_exitoso");
        } else {
            vista.mostrarMensajeDron("reemplazo_fallido");
        }
    }

    /**
     * Muestra el estado del AntCiberDron
     */
    private void estadoDron() {
        vista.mostrarEstadoDron(dron);
    }

    /**
     * Realiza una prueba de vuelo
     */
    private void pruebaVuelo() {
        vista.mostrarMensajeOperacion("titulo_vuelo");
        
        if (dron.getPiloto() == null) {
            vista.mostrarMensajeOperacion("error_no_piloto_vuelo");
            return;
        }
        
        vista.mostrarMensajeOperacion("piloto_detectado", dron.getPiloto());
        vista.mostrarLoading();
        dron.volar();
    }
    
    /**
     * Dispara el láser de la pata delantera izquierda
     */
    private void dispararLaser() {
        vista.mostrarMensajeOperacion("titulo_laser");
        
        if (dron.getPiloto() == null) {
            vista.mostrarMensajeOperacion("error_no_piloto_disparo");
            return;
        }
        
        vista.mostrarMensajeOperacion("piloto_disparo", dron.getPiloto());
        dron.dispararLaser();
    }
    
    /**
     * Dispara la metralleta de la pata delantera derecha
     */
    private void dispararMetralleta() {
        vista.mostrarMensajeOperacion("titulo_metralleta");
        
        if (dron.getPiloto() == null) {
            vista.mostrarMensajeOperacion("error_no_piloto_disparo");
            return;
        }
        
        vista.mostrarMensajeOperacion("piloto_disparo", dron.getPiloto());
        dron.dispararMetralleta();
    }
    
    /**
     * Recarga la munición de la metralleta
     * Requiere que haya una hormiga integrada al AntCiberDron
     */
    private void recargarMunicion() {
        if (dron.getPiloto() == null) {
            vista.mostrarMensajeDron("error_sin_piloto_municion");
            return;
        }
        
        if (dron.getPataDelanteraDerecha() != null) {
            int municionAnterior = dron.getPataDelanteraDerecha().getMunicion();
            dron.getPataDelanteraDerecha().recargarMunicion();
            vista.mostrarMensajeDron("recarga_municion", municionAnterior, dron.getPataDelanteraDerecha().getMunicion(), dron.getPiloto());
        } else {
            vista.mostrarMensajeDron("no_metralleta");
        }
    }
    
    /**
     * Muestra el historial de entrenamientos registrados
     */
    private void verHistorialEntrenamientos() {
        List<String> historial = dron.getHistorialEntrenamientos();
        vista.mostrarHistorialEntrenamientos(historial);
    }
}
