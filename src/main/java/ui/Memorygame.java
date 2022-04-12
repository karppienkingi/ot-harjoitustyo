package ui;

import services.Gamelogic;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Mirka
 */
public class Memorygame {

    private Gamelogic logic;
    private int amountOfPairs;
    private Button[] buttons;
    private Button newgame;
    private Scene scene;
    private VBox game;
    private Label label;

    public Memorygame(int amount) {
        this.amountOfPairs = amount;
        this.logic = new Gamelogic(3);

        buttons = new Button[6];
        this.newgame = new Button("new game");
        this.newgame.setFocusTraversable(false);
        this.newgame.setMinSize(20,40);
        this.newgame.setFont(Font.font("Stone", 16));

        this.label = new Label("");
        this.label.setFont(Font.font("Stone", 40));
        this.label.setText("");

        for (int i = 0; i < 6; i++) {
            buttons[i] = new Button("" + (i));
            buttons[i].setMinSize(100, 200);
            buttons[i].setFocusTraversable(false);
        }

        for (final Button b : buttons) {
            b.setOnAction((event) -> {
                if (logic.getTurned() == -1) {

                    logic.chosenCard = Integer.valueOf(b.getText());
                    logic.setTurned(Integer.valueOf(b.getText()));
                    b.setDisable(true);
                } else {
                    logic.turn(buttons);
                    this.label.setText(logic.MatchCheck(Integer.valueOf(b.getText()), buttons));
                    if (logic.winCheck()) {
                        endGame();
                    }
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

        this.game = new VBox();
        this.game.getChildren().add(board);
        this.game.setFillWidth(false);
        this.game.getChildren().add(this.label);
        this.game.getChildren().add(newgame);
        this.newgame.setVisible(false);

        this.scene = new Scene(this.game, 600, 600, Color.GHOSTWHITE);
    }

    public Scene setGame() {
        return scene;
    }

    private void endGame() {
        this.newgame.setVisible(true);
        this.newgame.setOnAction((event) -> {
            this.logic = new Gamelogic(3);
            this.newgame.setVisible(false);
            for (int i = 0; i < buttons.length; i++) {
            buttons[i].setDisable(false);
            this.label.setText("");
            
        }
        });
        
        setGame();
    }

}
