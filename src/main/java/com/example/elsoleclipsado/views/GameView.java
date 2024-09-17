package com.example.elsoleclipsado.views;

import com.example.elsoleclipsado.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Stage {

    private GameController gameController;

    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/elsoleclipsado/star-view.fxml")
        );
        Parent root = loader.load();
        this.gameController = loader.getController();
        this.setTitle("El sol eclipsado");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }


    public static GameView getInstance() throws IOException {
        if (GameViewHolder.INSTANCE == null) {
            return GameViewHolder.INSTANCE = new GameView();
        } else {
            return GameViewHolder.INSTANCE;
        }
    }

    private static class GameViewHolder {
        private static GameView INSTANCE;
    }
}

