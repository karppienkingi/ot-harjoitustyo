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
import javafx.stage.Stage;

/**
 *
 * @author Mirka
 */
public class Memorygame {

    private Gamelogic logic;
    private final int amountOfPairs;
    private Button[] buttons;
    private Button newgame;
    private Button toMenu;
    private Scene gameView;
    private VBox game;
    private Label label;
    private Scene menuView;
    private Stage stage;

    public Memorygame(int amount, Scene scene, Stage stage) {
        this.stage = stage;
        this.menuView = scene;
        this.amountOfPairs = amount;
        this.logic = new Gamelogic(this.amountOfPairs);

        buttons = new Button[this.amountOfPairs * 2];

        this.newgame = new Button("new game");
        this.newgame.setFocusTraversable(false);
        this.newgame.setMinSize(20, 40);
        this.newgame.setFont(Font.font("Stone", 16));

        this.toMenu = new Button("Back to menu");
        this.toMenu.setFocusTraversable(false);
        this.toMenu.setMinSize(20, 40);
        this.toMenu.setFont(Font.font("Stone", 16));

        this.label = new Label("");
        this.label.setFont(Font.font("Stone", 40));
        this.label.setText("");

        for (int i = 0; i < amount * 2; i++) {
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
        this.game.getChildren().addAll(this.newgame, this.toMenu);
        this.newgame.setVisible(false);
        this.toMenu.setVisible(false);

        this.gameView = new Scene(this.game, 600, 600, Color.GHOSTWHITE);
    }

    public Scene setGame() {
        return gameView;
    }

    public void setMenu() {
        this.stage.setScene(menuView);
    }

    private void endGame() {
        this.newgame.setVisible(true);
        this.toMenu.setVisible(true);
        this.newgame.setOnAction((event) -> {
            this.logic = new Gamelogic(this.amountOfPairs);
            this.newgame.setVisible(false);
            this.toMenu.setVisible(false);
            for (Button button : buttons) {
                button.setDisable(false);
                this.label.setText("");
            }
            setGame();
        });

        this.toMenu.setOnAction((event) -> {
            this.newgame.setVisible(false);
            this.toMenu.setVisible(false);
            setMenu();
        });

    }

}
