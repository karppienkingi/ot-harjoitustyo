package com.mvaana.memorygame;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import services.Gamelogic;

/**
 * JavaFX App
 */
public class App extends Application {
    
    static Button[] buttons;

    @Override
    public void start(Stage stage) {
        Gamelogic logic = new Gamelogic(3);

        VBox memorygame = new VBox();

        buttons = new Button[6];

        Label label = new Label("");
        label.setFont(Font.font("Stone", 60));
        label.setText("");

        for (int i = 0; i < 6; i++) {
            buttons[i] = new Button("" + (i));
            buttons[i].setMinSize(100, 200);
        }

        for (final Button b : buttons) {
            b.setOnAction((event) -> {
                System.out.println("Chosen " + b.getText());
                if (logic.getTurned() == -1) {

                    logic.chosenCard = Integer.valueOf(b.getText());
                    logic.setTurned(Integer.valueOf(b.getText()));
                    b.setDisable(true);
                } else {
                    logic.turn(buttons);
                    label.setText(logic.MatchCheck(Integer.valueOf(b.getText()), buttons));
                    logic.setTurned(-1);
                }
            });
        }

        TilePane board = new TilePane();
        board.setHgap(5);
        board.setVgap(5);
        board.getChildren().addAll(buttons);
        board.setTileAlignment(Pos.TOP_LEFT);
        board.setOrientation(Orientation.HORIZONTAL);
        board.setPrefColumns(3);
        board.setPrefRows(2);

        memorygame.getChildren().add(board);
        memorygame.setFillWidth(false);
        memorygame.getChildren().add(label);

        Scene scene = new Scene(memorygame, 600, 600, Color.GHOSTWHITE);

        stage.setScene(scene);
        stage.setTitle("Working title");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
