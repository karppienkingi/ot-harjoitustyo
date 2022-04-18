package com.mvaana.memorygame.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.mvaana.memorygame.ui.Memorygame;

/**
 * JavaFX App
 */
public class App extends Application {

    static Memorygame game;

    @Override
    public void start(Stage stage) {

        Label title = createLabel("Memorygame without pictures atm", 40);
        Label text = createLabel("Select a level of difficulty", 20);
        
        BorderPane pane = new BorderPane();
        
        Scene scene = new Scene(pane);

        Button zero = createButton("zero challenge", 1, stage, scene);
        Button easy = createButton("easy", 3, stage, scene);
        Button medium = createButton("medium", 6, stage, scene);
        Button hard = createButton("hard", 12, stage, scene);

        VBox buttons = new VBox();
        buttons.getChildren().addAll(text, zero, easy, medium, hard);

        pane.setTop(title);
        pane.setAlignment(title, Pos.CENTER);
        pane.setCenter(buttons);
        pane.setAlignment(buttons, Pos.TOP_CENTER);

        stage.setScene(scene);
        stage.setTitle("Working title");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    private static Label createLabel(String text, int fontSize) {
        Label label = new Label(text);
        label.setFont(Font.font("Stone", fontSize));
        label.setPadding(new Insets(2, 2, 2, 2));
        return label;
    }

    private static Button createButton(String text, Integer amountOfPairs, Stage stage, Scene scene) {
        Button button = new Button(text);
        button.setMinSize(50, 40);

        button.setOnAction((event) -> {
            game = new Memorygame(amountOfPairs, scene, stage);
            stage.setScene(game.setGame());
        });
        return button;
    }

}
