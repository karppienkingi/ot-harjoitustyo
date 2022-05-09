package com.mvaana.memorygame.ui;

import com.mvaana.memorygame.services.Gamelogic;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
    private final Button newgame;
    private final Button toMenu;
    private final Scene gameView;
    private final VBox game;
    private Label roundResult;
    private Label counter;
    private final Scene menuView;
    private final Stage stage;

    /**
     *
     * Constructor for Memorygame class
     *
     * @param amount amount of pairs in game
     * @param scene scene object to build layout of the game
     * @param stage stage object to show layout to users
     */
    public Memorygame(int amount, Scene scene, Stage stage) {
        this.stage = stage;
        this.menuView = scene;
        this.amountOfPairs = amount;
        this.logic = new Gamelogic(this.amountOfPairs);

        this.newgame = createButton("Play again");
        this.toMenu = createButton("Back to menu");

        this.roundResult = createLabel("");
        
        this.counter = createLabel("TRY COUNT: 0");
        
        buttons = new Button[this.amountOfPairs * 2];
        
        for (int i = 0; i < amount * 2; i++) {
            buttons[i] = new Button("" + (i));
            buttons[i].setMinSize(120, 200);
            buttons[i].setFocusTraversable(false);
        }

        for (final Button b : buttons) {
            b.setOnAction((event) -> {
                if (logic.getTurned() == -1) {
                    logic.pickFirst(buttons, Integer.valueOf(b.getText()));
                } else {                  
                    this.roundResult.setText(logic.pickSecond(buttons, Integer.valueOf(b.getText())));
                    this.counter.setText("TRY COUNT: " + logic.getCounter());
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

        if (amount <= 3) {
            board.setPrefColumns(3);
        } else if (amount == 6) {
            board.setPrefColumns(4);
            this.stage.setWidth(1000);
            this.stage.setHeight(700);
        } else {
            board.setPrefColumns(6);
            this.stage.setWidth(1200);
            this.stage.setHeight(900);
        }

        VBox buttonlist = new VBox(5);
        buttonlist.setAlignment(Pos.CENTER);
        buttonlist.getChildren().addAll(this.counter, this.newgame, this.toMenu);

        this.game = new VBox();
        this.game.getChildren().addAll(board, this.roundResult);
        this.game.setFillWidth(false);

        GridPane grid = createGrid();
        grid.add(this.game, 0, 0, 1, 1);
        grid.add(buttonlist, 1, 0, 1, 1);

        this.gameView = new Scene(grid, 600, 600, Color.GHOSTWHITE);
    }

    /**
     *
     * Returns game scene
     *
     * @return scene object of a game layout
     */
    public Scene setGame() {
        return gameView;
    }

    /**
     *
     * Sets scene to menu view
     */
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
            this.counter.setText("TRY COUNT: 0");
            for (Button button : buttons) {
                button.setDisable(false);
                logic.turnAll(buttons);
                this.roundResult.setText("");
            }
            setGame();
        });

        this.toMenu.setOnAction((event) -> {
            this.newgame.setVisible(false);
            this.toMenu.setVisible(false);
            setMenu();
        });

    }
    
    private static Label createLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Stone", 40));
        label.setPadding(new Insets(2, 2, 2, 2));
        return label;
    }

    private Button createButton(String name) {
        Button button = new Button(name);
        button.setFocusTraversable(false);
        button.setPrefSize(150, 30);
        button.setFont(Font.font("Stone", 16));
        button.setVisible(false);

        return button;
    }

    private GridPane createGrid() {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(5);
        pane.setPadding(new Insets(10, 10, 10, 10));

        return pane;
    }

}
