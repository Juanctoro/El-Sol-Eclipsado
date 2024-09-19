package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.models.Juego;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameController {

    @FXML
    private Label showHiddenWord, showPercentage, labelAttempts, labelHelp;
    @FXML
    private TextField incomeLetter;
    @FXML
    private ImageView imagePercentagesEclipse;
    @FXML
    private Button buttonHelp, buttonVerify;

    private  String word;
    private Juego game;
    private int failures = 0;

    public void startGame(String secretWord) {
        this.word = secretWord;
        this.game = new Juego(secretWord);
        showHiddenWord.setText(game.obtenerProgreso());
        labelAttempts.setText(Integer.toString(game.getIntentosRestantes()));
        labelHelp.setText(Integer.toString(game.getUsosDeAyuda()));
    }

    public void getLetterInput() {
        String letter = incomeLetter.getText();
        incomeLetter.clear();
        if(verificarLetraValida(letter) && letter.length() == 1) {
            boolean esCorrecta = game.adivinarLetra(letter.charAt(0));
            if (esCorrecta) {
                showHiddenWord.setText(game.obtenerProgreso());
                winGame();
            } else {
                failures++;
                String porcentaje = (failures*20) + "%";
                showPercentage.setText(porcentaje);
                percent();
                if(game.juegoTerminado()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Perdiste, el sol se eclipso totalmente");
                    alert.showAndWait();
                    incomeLetter.setDisable(true);
                    buttonHelp.setDisable(true);
                    buttonVerify.setDisable(true);
                }
            }
            labelAttempts.setText(Integer.toString(game.getIntentosRestantes()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Letra no valida");
            alert.showAndWait();
        }
    }

    public void usoAyudas() {
        game.usarAyuda();
        labelHelp.setText(Integer.toString(game.getUsosDeAyuda()));
        showHiddenWord.setText(game.obtenerProgreso());
        winGame();
    }

    public boolean verificarLetraValida(String palabra) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
    }

    public void winGame(){
        if (Objects.equals(game.obtenerProgreso(), word)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ganaste!!!");
            alert.setHeaderText(null);
            alert.setContentText("Felicitaciones, lograste adivinar la palabra secreta!!");
            alert.showAndWait();
            incomeLetter.setDisable(true);
            buttonHelp.setDisable(true);
            buttonVerify.setDisable(true);
        }
    }

    public void percent(){
        int numberImage = failures*20;
        String imagePath = "/com/example/elsoleclipsado/images/" + numberImage + ".jpg";
        imagePercentagesEclipse.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))));
    }
}
