package com.example.elsoleclipsado;

import com.example.elsoleclipsado.views.StartView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * La clase TheEclipsedSun es la clase principal de la aplicación "El Sol Eclipsado".
 * Extiende la clase Application de JavaFX para iniciar la aplicación gráfica.
 * @author Juan Toro
 */
public class TheEclipsedSun extends Application {

    /**
     * Método principal que inicia la aplicación JavaFX.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {launch(args);}

    /**
     * Método que crea la vista de inicio del juego.
     *
     * @param primaryStage La etapa primaria que se utiliza para mostrar la interfaz gráfica.
     * @throws IOException Si hay un error al cargar la vista de inicio.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        StartView.getInstance();
    }
}