package com.example.elsoleclipsado.models;

import com.example.elsoleclipsado.interfaces.ISecretWord;
import java.util.Arrays;

/**
 * Esta clase representa la palabra secreta que debe adivinarse en el juego.
 * Implementa la interfaz ISecretWord y gestiona el estado de la palabra, incluyendo
 * la verificación de letras correctas, el progreso y las ayudas.
 * @author Juan Toro
 */
public class SecretWord implements ISecretWord {
    private final String word;
    private final char[] progress;

    /**
     * Constructor que inicializa la palabra secreta y rellena el progreso con guiones bajos(_).
     *
     * @param word La palabra secreta que el jugador debe adivinar.
     */
    public SecretWord(String word) {
        this.word = word;
        this.progress = new char[word.length()];
        Arrays.fill(progress, '_');
    }

    /**
     * Verifica si una letra pertenece a la palabra secreta y actualiza el progreso.
     *
     * @param letter La letra que el jugador ingreso.
     * @return true si la letra pertenece a la palabra, false si no.
     */
    @Override
    public boolean checkAndUpdateLetter(char letter) {
        boolean correct = false;

        letter = Character.toLowerCase(letter);

        for (int i = 0; i < word.length(); i++) {
            char letterWord = Character.toLowerCase(word.charAt(i));

            if (letterWord == letter || noAccent(letterWord) == letter || letter == withAccent(letterWord)) {
                progress[i] = word.charAt(i);
                correct = true;
            }
        }
        return correct;
    }

    /**
     * Devuelve la siguiente letra que aún no ha sido adivinada para la ayuda(orden de 0 a n).
     *
     * @return La siguiente letra no descubierta, o null si ya no quedan letras por adivinar(null por precaucion y sintaxis).
     */
    @Override
    public Character getNextUnrevealedLetter(){
        for (int i = 0; i < progress.length; i++) {
            if (progress[i] == '_') {
                return word.charAt(i);
            }
        }
        return null;
    }

    /**
     * Obtiene el progreso actual de la palabra, con letras adivinadas y guiones bajos para las letras no adivinadas.
     *
     * @return Un string que representa el estado actual de la palabra (p. ej., "_a_a_a").
     */
    @Override
    public String getProgress() {
        return new String(progress);
    }

    /**
     * Convierte una letra con acento en su versión sin acento.
     *
     * @param c La letra con acento.
     * @return La letra sin acento, o la misma letra si no tiene acento.
     */
    private char noAccent(char c) {
        return switch (c) {
            case 'á', 'Á' -> 'a';
            case 'é', 'É' -> 'e';
            case 'í', 'Í' -> 'i';
            case 'ó', 'Ó' -> 'o';
            case 'ú', 'Ú' -> 'u';
            default -> (c);
        };
    }

    /**
     * Convierte una letra sin acento en su versión con acento.
     *
     * @param c La letra sin acento.
     * @return La letra con acento correspondiente, o la misma letra si no aplica.
     */
    private char withAccent(char c) {
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
