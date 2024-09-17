package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.models.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GameController {

    @FXML
    private Button buttonJugar;

    public boolean verificarPalabraValida(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }

    public void Jugar(ActionEvent event) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta;

        while (true){
            // Ingreso de la palabra secreta
            System.out.println("Bienvenido a 'El Sol Eclipsado'. Por favor, ingresa la palabra secreta para comenzar:");
            palabraSecreta = scanner.nextLine();
            if (verificarPalabraValida(palabraSecreta) && palabraSecreta.length() >= 6 && palabraSecreta.length() <= 12){
                break;
            } else {
                System.out.println("Palabra no valida.");
            }
        }

        // Crear una instancia del juego
        Juego juego = new Juego(palabraSecreta);

        // Bucle principal del juego
        while (!juego.juegoTerminado() && juego.getIntentosRestantes() > 0) {
            System.out.println("\nPalabra actual: " + juego.obtenerProgreso());
            System.out.println("Intentos restantes: " + juego.getIntentosRestantes());
            System.out.println("Ayudas restantes: " + juego.getUsosDeAyuda());

            // Menú de opciones
            System.out.println("Elige una opción:");
            System.out.println("1. Adivinar letra");
            System.out.println("2. Usar ayuda");
            System.out.println("3. Salir del juego");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Asegura que se ingrese un número válido
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número del 1 al 3.");
                continue; // Vuelve a preguntar
            }

            switch (opcion) {
                case 1:
                    // Adivinar letra
                    System.out.println("Ingresa una letra:");
                    String entrada = scanner.nextLine();

                    // Validar que solo se ingrese una letra del alfabeto español
                    if (entrada.length() != 1 || !verificarPalabraValida(entrada)) {
                        System.out.println("Entrada no válida. Por favor, ingresa solo una letra válida (del alfabeto español).");
                        continue; // Vuelve a preguntar
                    }

                    char letra = entrada.charAt(0);
                    boolean esCorrecta = juego.adivinarLetra(letra);

                    if (esCorrecta) {
                        System.out.println("¡Correcto!");
                    } else {
                        System.out.println("¡Incorrecto! El sol se eclipsa un poco más...");
                    }
                    break;

                case 2:
                    // Usar ayuda
                    boolean seUsoAyuda = juego.usarAyuda();
                    if (seUsoAyuda) {
                        System.out.println("Se ha revelado una letra.");
                    } else {
                        System.out.println("No te quedan ayudas.");
                    }
                    break;

                case 3:
                    // Salir del juego
                    System.out.println("Gracias por jugar.");
                    return;

                default:
                    System.out.println("Opción no válida. Elige un número del 1 al 3.");
                    break;
            }

            // Verificar si el juego ha terminado
            if (juego.obtenerProgreso().equals(palabraSecreta)) {
                System.out.println("¡Felicidades! Has adivinado la palabra secreta.");
                break;
            }
        }

        if (juego.getIntentosRestantes() == 0) {
            System.out.println("Lo siento, has perdido. La palabra secreta era: " + palabraSecreta);
        }

        scanner.close();
    }

}
