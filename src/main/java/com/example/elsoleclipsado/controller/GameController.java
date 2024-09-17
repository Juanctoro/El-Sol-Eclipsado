package com.example.elsoleclipsado.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GameController {

    public boolean verificarPalabraValida(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }
}
