package com.example.elsoleclipsado.interfaces;

/**
 * La interfaz ISecretWord define las metodos para gestionar la plabra secreta.
 * Proporciona métodos para verificar letras, obtener el progreso
 * y brindar ayuda al jugador.
 * @author Juan Toro
 */
public interface ISecretWord {

    /**
     * Verifica si la letra proporcionada está en la palabra secreta y actualiza el progreso en consecuencia.
     * @param letter La letra que el jugador ingreso.
     * @return true si la letra pertenece a la palabra, false si no.
     */
    boolean checkAndUpdateLetter(char letter);

    /**
     * Devuelve la siguiente letra que aún no ha sido adivinada.
     * @return La siguiente letra no descubierta.
     */
    Character getNextUnrevealedLetter();

    /**
     * Devuelve el estado actual de la palabra secreta, mostrando letras adivinadas
     * y guiones bajos para las letras no adivinadas.
     * @return Un string que representa el estado actual de la palabra.
     */
    String getProgress();
}
