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
            gameController.recibirTexto(texto);
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
}
