package com.example.elsoleclipsado;

import com.example.elsoleclipsado.views.StartView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class TheEclipsedSun extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws IOException {
        StartView.getInstance();
    }
}