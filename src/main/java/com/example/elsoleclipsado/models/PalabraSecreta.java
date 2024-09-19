package com.example.elsoleclipsado.models;

import com.example.elsoleclipsado.interfaces.IPalabraSecreta;

import java.util.Arrays;


public class PalabraSecreta implements IPalabraSecreta {
    private final String palabra;
    private final char[] progreso;

    public PalabraSecreta(String palabra) {
        this.palabra = palabra;
        this.progreso = new char[palabra.length()];
        Arrays.fill(progreso, '_');
    }

    @Override
    public boolean verificarLetra(char letra) {
        boolean acertado = false;

        letra = Character.toLowerCase(letra);

        for (int i = 0; i < palabra.length(); i++) {
            char letraPalabra = Character.toLowerCase(palabra.charAt(i));

            if (letraPalabra == letra || sinAcento(letraPalabra) == letra || letra == conAcento(letraPalabra)) {
                progreso[i] = palabra.charAt(i);
                acertado = true;
            }
        }
        return acertado;
    }

    @Override
    public Character getLetra(){
        for (int i = 0; i < progreso.length; i++) {
            if (progreso[i] == '_') {
                return palabra.charAt(i);
            }
        }
        return null;
    }

    @Override
    public String obtenerProgreso() {
        return new String(progreso);
    }

    private char sinAcento(char c) {
        return switch (c) {
            case 'á', 'Á' -> 'a';
            case 'é', 'É' -> 'e';
            case 'í', 'Í' -> 'i';
            case 'ó', 'Ó' -> 'o';
            case 'ú', 'Ú' -> 'u';
            default -> (c);
        };
    }

    private char conAcento(char c) {
        return switch (c) {
            case 'a', 'A' -> 'á';
            case 'e', 'E' -> 'é';
            case 'i', 'I' -> 'í';
            case 'o', 'O' -> 'ó';
            case 'u', 'U' -> 'ú';
            case 'ñ', 'Ñ' -> 'ñ';
            default -> (c);
        };
    }
}
