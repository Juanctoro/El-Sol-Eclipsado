package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.views.GameView;
import com.example.elsoleclipsado.views.StartView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
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
}
