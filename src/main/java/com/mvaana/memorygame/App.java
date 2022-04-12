package com.mvaana.memorygame;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ui.Memorygame;

/**
 * JavaFX App
 */
public class App extends Application {

    static Button[] buttons;

    @Override
    public void start(Stage stage) {

        Memorygame game = new Memorygame(3);
        stage.setScene(game.setGame());
        stage.setTitle("Working title");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
