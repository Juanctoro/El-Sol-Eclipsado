package com.example.elsoleclipsado.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase StartView representa la vista inicial/start del juego "El Sol Eclipsado".
 * @author Juan Toro
 */
public class StartView extends Stage {

    /**
     * Constructor de StartView. Carga el archivo FXML para la vista de inicio
     * y configura la escena de la ventana.
     *
     * @throws IOException Si hay un error al cargar el archivo FXML.
     */
    public StartView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/elsoleclipsado/fxml/start-view.fxml")
        );
        Parent root = loader.load();
        this.setTitle("El sol eclipsado - Start");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }

    /**
     * Obtiene la instancia única de StartView.
     * Si no se ha creado una instancia de StartView, la crea.
     *
     * @throws IOException Si hay un error al crear la instancia.
     */
    public static void getInstance() throws IOException {
        if (GameViewHolder.INSTANCE == null) {
            GameViewHolder.INSTANCE = new StartView();
        }
    }

    /**
     * Clase interna estática para mantener la instancia única de StartView.
     */
    private static class GameViewHolder {
        private static StartView INSTANCE;
    }
}

