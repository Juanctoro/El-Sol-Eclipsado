package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.views.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controlador de la ventana de inicio del juego 'El Sol Eclipsado'.
 * Permite ingresar la palabra secreta y muestra las instrucciones del juego.
 * @author Juan Toro
 */
public class StartController {

    @FXML
    private Button buttonPlay;

    @FXML
    private TextField textFieldSecretWord;

    /**
     * Inicia el juego si la palabra ingresada es válida. La palabra debe
     * tener entre 6 y 12 caracteres y solo contener letras.
     * Cierra la ventana actual (el Start) y muestra la ventana principal del juego.
     *
     * @throws IOException si ocurre un error al cargar la vista del juego.
     */
    @FXML
    public void start() throws IOException {
        String text = textFieldSecretWord.getText();
        if (verifyValidWord(text) && text.length() <= 5) {
            Stage currentStage = (Stage) buttonPlay.getScene().getWindow();
            if (currentStage != null) {
                currentStage.close();
            }
            GameView gameView = GameView.getInstance();
            gameView.show();
            GameController gameController = gameView.getGameController();
            gameController.startGame(text);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("La palabra no es válida. Debe tener entre 6 y 12 caracteres y solo contener letras.");
            alert.showAndWait();
        }
    }

    /**
     * Verifica si la palabra ingresada es válida. La palabra debe contener
     * solo letras, incluyendo letras con acentos y la letra 'ñ'.
     *
     * @param palabra La palabra que se va a verificar.
     * @return true si la palabra es válida, false en caso de que no sea valida.
     */
    public boolean verifyValidWord(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }

    /**
     * Muestra un alert box con las instrucciones del juego.
     */
    public void instructions() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instrucciones");
        alert.setHeaderText(null);
        alert.setContentText("""
                Aquí te dejo una breve explicación de cómo jugar:
                
                1. Ingreso de la palabra secreta: Ingresa una palabra de 6 a 12 letras que el jugador debe adivinar.
                2. Adivina la palabra: El jugador tiene 5 intentos para adivinar la palabra letra por letra. Cada vez que falla, el sol se eclipsa un 20%.
                3. Opción de ayuda: Puedes utilizar la opción de ayuda hasta 3 veces, revelando una letra correcta.
                4. Ganancia o pérdida: Si adivinas la palabra antes de que el sol se eclipse por completo, ganas. Si no, pierdes.
                
                ¡Intenta adivinar la palabra antes de que el sol desaparezca completamente!.""");
        alert.showAndWait();
    }
}
