package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.models.Juego;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameController {

    @FXML
    private Text mostrarPalabraOculta;
    @FXML
    private TextField ingresoDeLetra;
    @FXML
    private Label mostrarPocentaje, labelIntentos, labelAyudas;

    private Juego juego;
    private int fallos = 0;

    public void iniciarJuego(String palabraSecreta) {
        this.juego = new Juego(palabraSecreta);
        mostrarPalabraOculta.setText(juego.obtenerProgreso());
        labelIntentos.setText(Integer.toString(juego.getIntentosRestantes()));
        labelAyudas.setText(Integer.toString(juego.getUsosDeAyuda()));
    }

    public void setIngresoDeLetra() {
        String letra = ingresoDeLetra.getText();
        ingresoDeLetra.clear();
        if(verificarLetraValida(letra) && letra.length() == 1) {
            boolean esCorrecta = juego.adivinarLetra(letra.charAt(0));
            if (esCorrecta) {
                mostrarPalabraOculta.setText(juego.obtenerProgreso());
            } else {
                fallos++;
                String porcentaje = (fallos*20) + "%";
                mostrarPocentaje.setText(porcentaje);
                if(juego.juegoTerminado()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Perdiste, no te quedan inntentos");
                    alert.showAndWait();
                    ingresoDeLetra.setDisable(true);
                }
            }
            labelIntentos.setText(Integer.toString(juego.getIntentosRestantes()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Letra no valida");
            alert.showAndWait();
        }
    }

    public void usoAyudas() {
        juego.usarAyuda();
        labelAyudas.setText(Integer.toString(juego.getUsosDeAyuda()));
        mostrarPalabraOculta.setText(juego.obtenerProgreso());
    }

    public boolean verificarLetraValida(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }
}
