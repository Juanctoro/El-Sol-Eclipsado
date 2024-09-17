package com.example.elsoleclipsado.views;

import com.example.elsoleclipsado.controller.GameController;
import com.example.elsoleclipsado.controller.StartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView extends Stage {

    private StartController startController;

    public StartView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/elsoleclipsado/start-view.fxml")
        );
        Parent root = loader.load();
        this.startController = loader.getController();
        this.setTitle("El sol eclipsado - Start");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }


    public static StartView getInstance() throws IOException {
        if (GameViewHolder.INSTANCE == null) {
            return GameViewHolder.INSTANCE = new StartView();
        } else {
            return GameViewHolder.INSTANCE;
        }
    }

    private static class GameViewHolder {
        private static StartView INSTANCE;
    }
}

