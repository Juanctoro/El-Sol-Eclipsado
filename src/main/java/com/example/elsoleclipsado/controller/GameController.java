package com.example.elsoleclipsado.controller;

import com.example.elsoleclipsado.models.Game;
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

/**
 * Controlador principal del juego 'El Sol Eclipsado'.
 * Aca se gestionan los eventos (mouse y teclado) que genere el jugador con la interfaz y la lógica del juego.
 * @author Juan Toro
 */
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
    private Game game;
    private int failures = 0;

    /**
     * Inicia el juego con la palabra secreta que llega del StartController.
     * Setea en la interfaz los valores iniciales del juego como la palabra oculta, intentos y ayudas restantes.
     *
     * @param secretWord La palabra secreta que se va a a adivinar.
     */
    public void startGame(String secretWord) {
        this.word = secretWord;
        this.game = new Game(secretWord);
        showHiddenWord.setText(game.getProgress());
        labelAttempts.setText(Integer.toString(game.getRemainingAttempts()));
        labelHelp.setText(Integer.toString(game.getHelpUses()));
    }

    /**
     * Recibe la letra ingresada por el jugador.
     * Verifica si la letra es válida, actualiza el progreso (array) del juego y gestiona los fallos si es necesario.
     * Si se alcanza el máximo de fallos, finaliza el juego y deshabilita las entradas.
     */
    public void getLetterInput() {
        String letter = incomeLetter.getText();
        incomeLetter.clear();
        if(verifyValidLetter(letter) && letter.length() == 1) {
            boolean isCorrect = game.guessLetter(letter.charAt(0));
            if (isCorrect) {
                showHiddenWord.setText(game.getProgress());
                winGame();
            } else {
                failures++;
                String percentage = (failures*20) + "%";
                showPercentage.setText(percentage);
                percent();
                if(game.gameFinished()){
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
            labelAttempts.setText(Integer.toString(game.getRemainingAttempts()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Letra no valida");
            alert.showAndWait();
        }
    }

    /**
     * Utiliza una ayuda del juego, revelando una letra de la palabra secreta.
     * Actualiza la interfaz con el progreso del jugador y la cantidad de ayudas restantes.
     */
    public void useHelps() {
        game.useHelp();
        labelHelp.setText(Integer.toString(game.getHelpUses()));
        showHiddenWord.setText(game.getProgress());
        winGame();
    }

    /**
     * Verifica si la letra ingresada es válida.
     * Solo permite letras, incluyendo letras con acentos y la letra 'ñ' usando una cadena de expreciones regulares.
     *
     * @param word La letra que se desea verificar.
     * @return true si la letra es válida, false si no lo es.
     */
    public boolean verifyValidLetter(String word) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    /**
     * Verifica si el jugador ha ganado el juego, es decir, si advino la plabra secreta.
     * Si el jugador gana, deshabilita las entradas
     * y muestra un mensaje de felicitación.
     */
    public void winGame(){
        if (Objects.equals(game.getProgress(), word)) {
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

    /**
     * Actualiza la imagen del eclipse en función del número de fallos cometidos.
     * Cada fallo aumenta un 20% el eclipse.
     */
    public void percent(){
        int numberImage = failures*20;
        String imagePath = "/com/example/elsoleclipsado/images/" + numberImage + ".jpg";
        imagePercentagesEclipse.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))));
    }
}
