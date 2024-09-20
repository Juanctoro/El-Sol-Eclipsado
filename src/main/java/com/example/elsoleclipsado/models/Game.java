package com.example.elsoleclipsado.models;

import com.example.elsoleclipsado.interfaces.IGame;

/**
 * Clase que implementa la lógica del juego 'El Sol Eclipsado'.
 * Aca estan los intentos, el uso de ayudas y verifica si el juego ha terminado.
 * @author Juan Toro
 */
public class Game implements IGame {
    private final SecretWord secretWord;
    private int attemptsRemaining;
    private int helpUses;
    private boolean gameFinished;

    /**
     * Constructor de la clase Game.
     * Inicializa el juego con una palabra secreta y establece los intentos y ayudas disponibles.
     *
     * @param secretWord La palabra secreta que el jugador debe adivinar.
     */
    public Game(String secretWord) {
        this.secretWord = new SecretWord(secretWord);
        this.attemptsRemaining = 5;
        this.helpUses = 3;
        this.gameFinished = false;
    }

    /**
     * Realiza una adivinanza (si esta o no) con la letra ingresada.
     * Si la letra es incorrecta, reduce el número de intentos restantes.
     *
     * @param letter La letra ingresada por el jugador.
     * @return true si la letra adivinada es correcta, false en caso contrario.
     */
    @Override
    public boolean guessLetter(char letter) {
        if (gameFinished) {
            return false;
        }

        boolean isCorrect = secretWord.checkAndUpdateLetter(letter);
        if (!isCorrect) {
            attemptsRemaining--;
            if (attemptsRemaining == 0) {
                gameFinished = true;
            }
        }
        return isCorrect;
    }

    /**
     * Utiliza una ayuda para revelar una letra de la palabra secreta.
     * El número de ayudas disponibles se reduce en 1 cada vez que se usa.
     */
    @Override
    public void useHelp() {
        if (helpUses > 0) {
            secretWord.checkAndUpdateLetter(secretWord.getNextUnrevealedLetter());
            helpUses--;
        }
    }

    /**
     * Verifica si el juego ha terminado, sea porque el jugador
     * adivino la palabra o porque agoto los intentos.
     *
     * @return true si el juego ha finalizado, false en caso contrario.
     */
    @Override
    public boolean gameFinished() {
        return gameFinished;
    }

    /**
     * Obtiene el número de intentos restantes.
     * Cada vez que el jugador falla una adivinanza, el número de intentos se reduce.
     *
     * @return El número de intentos restantes.
     */
    @Override
    public int getRemainingAttempts() {
        return attemptsRemaining;
    }

    /**
     * Obtiene el número de ayudas restantes que el jugador puede utilizar.
     *
     * @return El número de ayudas restantes.
     */
    @Override
    public int getHelpUses() {
        return helpUses;
    }

    /**
     * Obtiene el progreso actual del jugador, es decir, las letras que han sido adivinadas
     * correctamente hasta el momento.
     *
     * @return Una cadena que representa el progreso actual de la palabra secreta.
     */
    @Override
    public String getProgress() {
        return secretWord.getProgress();
    }
}
