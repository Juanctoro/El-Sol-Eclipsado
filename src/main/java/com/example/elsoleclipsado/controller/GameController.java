package com.example.elsoleclipsado.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GameController {

    @FXML
    private Text mostrarPalabraOculta;

    private String palabraSecreta;

    public boolean verificarPalabraValida(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }

    public void recibirTexto(String texto) {
        palabraSecreta = texto;
        mostrarPalabraOculta.setText(texto);
    }
}
