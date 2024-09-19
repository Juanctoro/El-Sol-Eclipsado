package com.example.elsoleclipsado.models;

public class Juego {
    private final PalabraSecreta palabraSecreta;
    private int intentosRestantes;
    private int usosDeAyuda;
    private boolean juegoTerminado;

    public Juego(String palabraSecreta) {
        this.palabraSecreta = new PalabraSecreta(palabraSecreta);
        this.intentosRestantes = 5; // Máximo de cinco intentos
        this.usosDeAyuda = 3; // Tres ayudas permitidas
        this.juegoTerminado = false;
    }

    public boolean adivinarLetra(char letra) {
        if (juegoTerminado) {
            return false; // El juego ha terminado
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

    public boolean usarAyuda() {
        if (usosDeAyuda > 0) {
            palabraSecreta.verificarLetra(palabraSecreta.getLetra());
            usosDeAyuda--;
            return true;
        }
        return false; // No quedan ayudas
    }

    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public int getUsosDeAyuda() {
        return usosDeAyuda;
    }

    public String obtenerProgreso() {
        return palabraSecreta.obtenerProgreso();
    }
}
