package com.example.elsoleclipsado.interfaces;

/**
 * Esta interfaz establece los métodos para gestionar las adivinanzas, ayudas,
 * estado del juego y el progreso de la palabra.
 * @author Juan Toro
 */
public interface IGame {

    /**
     * Realiza una adivinanza (si esta o no) con la letra ingresada.
     *
     * @param letter La letra ingresada por el jugador.
     * @return true si la letra adivinada es correcta, false en caso contrario.
     */
    boolean guessLetter(char letter);

    /**
     * Utiliza una ayuda para revelar una letra de la palabra secreta.
     */
    void useHelp();

    /**
     * Verifica si el juego ha terminado, es decir, si el jugador ha adivinado la palabra
     * o si se han agotado los intentos.
     * @return true si el juego ha finalizado, false en caso contrario.
     */
    boolean gameFinished();

    /**
     * Obtiene el número de intentos restantes que tiene el jugador para adivinar la palabra.
     * @return El número de intentos restantes.
     */
    int getRemainingAttempts();

    /**
     * Obtiene el número de ayudas restantes que tiene el jugador para revelar letras de la palabra secreta.
     * @return El número de ayudas restantes.
     */
    int getHelpUses();

    /**
     * Obtiene el progreso actual del jugador, mostrando las letras adivinadas correctamente
     * y ocultando las letras que aún no han sido reveladas.
     * @return Una cadena que representa el progreso actual de la palabra secreta.
     */
    String getProgress();
}
