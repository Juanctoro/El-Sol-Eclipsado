package com.example.elsoleclipsado.views;

import com.example.elsoleclipsado.controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * La clase GameView gestiona la vista del juego "El Sol Eclipsado" utilizando JavaFX.
 * @author Juan Toro
 */
public class GameView extends Stage {

    private static GameView instance;
    private final GameController gameController;

    /**
     * Constructor de GameView. Carga el archivo FXML para la vista del juego y
     * configura el controlador de la vista.
     *
     * @throws IOException Si hay un error al cargar el archivo FXML.
     */
    private GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/elsoleclipsado/fxml/game-view.fxml")
        );
        Parent root = loader.load();
        this.gameController = loader.getController();
        this.setTitle("El Sol Eclipsado - Juego");
        Scene scene = new Scene(root);
        this.setScene(scene);
    }

    /**
     * Obtiene la instancia única de GameView.
     * Si no se ha creado una instancia de GameView, la crea.
     *
     * @return La instancia única de GameView.
     * @throws IOException Si hay un error al crear la instancia.
     */
    public static GameView getInstance() throws IOException {
        if (instance == null) {
            instance = new GameView();
        }
        return instance;
    }

    /**
     * Devuelve el controlador asociado a la vista del juego.
     *
     * @return El controlador del juego (GameController).
     */
    public GameController getGameController() {
        return gameController;
    }
}
