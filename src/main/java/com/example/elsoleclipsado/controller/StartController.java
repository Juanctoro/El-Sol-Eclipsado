package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.views.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private Button buttonJugar;

    @FXML
    public void Jugar(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) buttonJugar.getScene().getWindow();
        if (currentStage != null) {
            currentStage.close();
        }
        GameView gameView = GameView.getInstance();
    }
}
