package com.example.elsoleclipsado.interfaces;

public interface IJuego {
    boolean adivinarLetra(char letra);
    void usarAyuda();
    boolean juegoTerminado();
    int getIntentosRestantes();
    int getUsosDeAyuda();
    String obtenerProgreso();
}
