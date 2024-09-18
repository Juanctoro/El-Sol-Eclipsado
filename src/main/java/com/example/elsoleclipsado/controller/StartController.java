package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.views.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartController {
    @FXML
    private Button buttonJugar;

    @FXML
    private TextField textFieldPalabraSecreta;

    @FXML
    public void Jugar(ActionEvent event) throws IOException {
        String texto = textFieldPalabraSecreta.getText();
        if (verificarPalabraValida(texto) && texto.length() >= 6 && texto.length() <= 12) {

            Stage currentStage = (Stage) buttonJugar.getScene().getWindow();
            if (currentStage != null) {
                currentStage.close();
            }
            GameView gameView = GameView.getInstance();
            gameView.show();
            GameController gameController = gameView.getGameController();
            gameController.iniciarJuego(texto);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("La palabra no es válida. Debe tener entre 6 y 12 caracteres y solo contener letras.");
            alert.showAndWait();
        }


    }

    public boolean verificarPalabraValida(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }

    public void instrucciones() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instrucciones");
        alert.setHeaderText(null);
        alert.setContentText("Aquí te dejo una breve explicación de cómo jugar:\n" +
                "\n" +
                "1. Ingreso de la palabra secreta: Ingresa una palabra de 6 a 12 letras que el jugador debe adivinar.\n" +
                "2. Adivina la palabra: El jugador tiene 5 intentos para adivinar la palabra letra por letra. Cada vez que falla, el sol se eclipsa un 20%.\n" +
                "3. Opción de ayuda: Puedes utilizar la opción de ayuda hasta 3 veces, revelando una letra correcta.\n" +
                "4. Ganancia o pérdida: Si adivinas la palabra antes de que el sol se eclipse por completo, ganas. Si no, pierdes.\n" +
                "\n¡Intenta adivinar la palabra antes de que el sol desaparezca completamente!.");
        alert.showAndWait();
    }
}
