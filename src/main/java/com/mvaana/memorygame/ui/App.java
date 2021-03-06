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

/**
 * JavaFX App
 *
 */
public class App extends Application {

    /**
     * Overridden method to start the app
     * @param stage stage object
     * The Menu view of the application
     */
    @Override
    public void start(Stage stage) {

        Label title = createLabel("Memory Game", 50);
        Label text = createLabel("Select a level of difficulty", 27);

        BorderPane pane = createPane();
        Scene scene = new Scene(pane);

        Button zero = createButton("Zero challenge", 1, stage, scene);
        Button easy = createButton("Easy", 3, stage, scene);
        Button medium = createButton("Medium", 6, stage, scene);
        Button hard = createButton("Hard", 12, stage, scene);

        VBox buttons = createBox(3);
        buttons.getChildren().addAll(text, zero, easy, medium, hard);

        pane.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        pane.setCenter(buttons);
        BorderPane.setAlignment(buttons, Pos.TOP_CENTER);

        stage.setWidth(900);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.setTitle("Memorygame");
        stage.show();

    }

    /**
     * Main method
     * @param args the command line arguments
     */
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
        Font font = Font.font("Stone", 20);
        button.setFont(font);
        button.setPrefSize(200, 35);
        button.setFocusTraversable(false);

        button.setOnAction((event) -> {
            Memorygame game = new Memorygame(amountOfPairs, scene, stage);
            stage.setScene(game.setGame());
        });
        return button;
    }
    
    private static BorderPane createPane() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));        
        return pane;
    }

    private VBox createBox(int i) {
        VBox box = new VBox(3);
        box.setPadding(new Insets(5, 5, 5, 5));
        return box;
    }

}
