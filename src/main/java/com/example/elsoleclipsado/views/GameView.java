package com.example.elsoleclipsado.views;

import com.example.elsoleclipsado.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Stage {

    private static GameView instance;
    private final GameController gameController;

    private GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/elsoleclipsado/game-view.fxml")
        );
        Parent root = loader.load();
        this.gameController = loader.getController();
        this.setTitle("El Sol Eclipsado - Juego");
        Scene scene = new Scene(root);
        this.setScene(scene);
    }

    public static GameView getInstance() throws IOException {
        if (instance == null) {
            instance = new GameView();
        }
        return instance;
    }

    public GameController getGameController() {
        return gameController;
    }
}
