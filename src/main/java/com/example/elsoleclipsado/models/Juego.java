package com.example.elsoleclipsado.models;

import com.example.elsoleclipsado.interfaces.IJuego;

public class Juego implements IJuego {
    private final PalabraSecreta palabraSecreta;
    private int intentosRestantes;
    private int usosDeAyuda;
    private boolean juegoTerminado;

    public Juego(String palabraSecreta) {
        this.palabraSecreta = new PalabraSecreta(palabraSecreta);
        this.intentosRestantes = 5;
        this.usosDeAyuda = 3;
        this.juegoTerminado = false;
    }
    @Override
    public boolean adivinarLetra(char letra) {
        if (juegoTerminado) {
            return false;
        }

        boolean esCorrecta = palabraSecreta.verificarLetra(letra);
        if (!esCorrecta) {
            intentosRestantes--;
            if (intentosRestantes == 0) {
                juegoTerminado = true;
            }
        }
        return esCorrecta;
    }

    @Override
    public void usarAyuda() {
        if (usosDeAyuda > 0) {
            palabraSecreta.verificarLetra(palabraSecreta.getLetra());
            usosDeAyuda--;
        }
    }

    @Override
    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    @Override
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    @Override
    public int getUsosDeAyuda() {
        return usosDeAyuda;
    }

    @Override
    public String obtenerProgreso() {
        return palabraSecreta.obtenerProgreso();
    }
}
