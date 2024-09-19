package com.example.elsoleclipsado.views;

import com.example.elsoleclipsado.controller.StartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartView extends Stage {
    public StartView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/elsoleclipsado/start-view.fxml")
        );
        Parent root = loader.load();
        StartController startController = loader.getController();
        this.setTitle("El sol eclipsado - Start");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }

    public static void getInstance() throws IOException {
        if (GameViewHolder.INSTANCE == null) {
            GameViewHolder.INSTANCE = new StartView();
        }
    }

    private static class GameViewHolder {
        private static StartView INSTANCE;
    }
}

