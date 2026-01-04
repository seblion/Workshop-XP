package com.kgd.anticiberdron.model.TecnologiaKGD;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class BBA {
    private String estadoActual;
    private Set<String> estadosAceptacion;

    public BBA() {
        this.estadoActual = "q0";
        // Estados de aceptación: q1, q2, q3, q5, q6, q7, q8
        this.estadosAceptacion = new HashSet<>(Arrays.asList("q1", "q2", "q3", "q5", "q6", "q7", "q8"));
    }

    /**
     * Autómata Finito Determinista (AFD) para BBA.
     * 
     * SOLO acepta estas expresiones:
     * - a+     
     * - ab*    
     * - abc    
     * - abcd*  
     * - abcdt+ 
     */
    public boolean validarObjetivo(String cadenaArsenal) {
        if (cadenaArsenal == null || cadenaArsenal.isEmpty()) {
            return false;
        }

        int estado = 0; // q0

        for (char c : cadenaArsenal.toCharArray()) {
            switch (estado) {
                case 0: // q0 (inicial)
                    if (c == 'a')
                        estado = 1; // -> q1
                    else
                        estado = -1;
                    break;

                case 1: // q1 (aceptación - "a")
                    if (c == 'a')
                        estado = 6; // -> q6 (a+)
                    else if (c == 'b')
                        estado = 2; // -> q2
                    else
                        estado = -1;
                    break;

                case 2: // q2 (aceptación - "ab")
                    if (c == 'b')
                        estado = 7; // -> q7 (ab*)
                    else if (c == 'c')
                        estado = 3; // -> q3
                    else
                        estado = -1;
                    break;

                case 3: // q3 (aceptación - "abc", ya que d* permite cero d's)
                    if (c == 'd')
                        estado = 4; // -> q4
                    else
                        estado = -1;
                    break;

                case 4: // q4 (aceptación - "abcd" primera d de abcd*)
                    if (c == 'd')
                        estado = 8; // -> q8 (abcd*)
                    else if (c == 't')
                        estado = 5; // -> q5 (abcdt+)
                    else
                        estado = -1;
                    break;

                case 5: // q5 (aceptación - "abcdt+")
                    if (c == 't')
                        estado = 5; // Loop q5
                    else
                        estado = -1;
                    break;

                case 6: // q6 (aceptación - "a+" loop)
                    if (c == 'a')
                        estado = 6; // Loop q6
                    else
                        estado = -1;
                    break;

                case 7: // q7 (aceptación - "ab*" loop)
                    if (c == 'b')
                        estado = 7; // Loop q7
                    else
                        estado = -1;
                    break;

                case 8: // q8 (aceptación - "abcd*" loop)
                    if (c == 'd')
                        estado = 8; // Loop q8
                    else
                        estado = -1;
                    break;

                default:
                    return false;
            }
            if (estado == -1)
                return false;
        }

        // Estados de aceptación: q1, q2, q3, q4, q5, q6, q7, q8
        return estado == 1 || estado == 2 || estado == 3 || estado == 4 || estado == 5 || 
               estado == 6 || estado == 7 || estado == 8;
    }


}
