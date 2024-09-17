package com.example.elsoleclipsado.models;

import java.util.Arrays;

public class PalabraSecreta {
    private final String palabra;
    private final char[] progreso;

    public PalabraSecreta(String palabra) {
        this.palabra = palabra;
        this.progreso = new char[palabra.length()];
        Arrays.fill(progreso, '_'); // Inicia con guiones bajos para ocultar las letras
    }


    public boolean verificarLetra(char letra) {
        boolean acertado = false;

        // Convertimos ambos a minúscula para permitir comparaciones de vocales con/sin acento
        letra = Character.toLowerCase(letra);

        for (int i = 0; i < palabra.length(); i++) {
            char letraPalabra = Character.toLowerCase(palabra.charAt(i));

            if (letraPalabra == letra || sinAcento(letraPalabra) == letra) {
                progreso[i] = palabra.charAt(i); // Revela la letra original (incluyendo acentos)
                acertado = true;
            }
        }
        return acertado;
    }

    public void revelarLetra() {
        for (int i = 0; i < progreso.length; i++) {
            if (progreso[i] == '_') {
                progreso[i] = palabra.charAt(i); // Revelamos la primera letra que no ha sido adivinada
                break;
            }
        }
    }

    public String obtenerProgreso() {
        return new String(progreso); // Retorna el estado actual de la palabra adivinada
    }

    private char sinAcento(char c) {
        return switch (c) {
            case 'á', 'Á' -> 'a';
            case 'é', 'É' -> 'e';
            case 'í', 'Í' -> 'i';
            case 'ó', 'Ó' -> 'o';
            case 'ú', 'Ú' -> 'u';
            default -> c;
        };
    }
}
