package com.mvaana.memorygame.services;

import com.mvaana.memorygame.domain.Cards;
import java.util.HashMap;
import javafx.scene.control.Button;

/**
 *
 * @author Mirka
 * Class that controls the logic of the game
 */
public class Gamelogic {

    private final Cards cards;
    private int first;
    private int second;
    private boolean lastMatch;
    private int turned;
    private int counter;
    private final int pairAmount;
    private int matches;
    private final HashMap<Integer, Integer> cardMatches;

    /**
     * 
     * Constructor for Gamelogic
     * @param amountOfPairs the amount of pairs in game
     * 
     */
    public Gamelogic(int amountOfPairs) {

        this.cardMatches = new HashMap<>();
        this.pairAmount = amountOfPairs;
        this.turned = -1;
        this.matches = 0;
        this.cards = new Cards(this.pairAmount);
        this.first = -1;
        this.second = -1;
        this.lastMatch = false;
        this.counter = 0;

    }

    /**
     *
     * First card pick in a round
     * @param buttons array of buttons used as cards in ui
     * @param cardnro picked card
     */
    public void pickFirst(Button[] buttons, int cardnro) {
        if (this.first != -1 && this.second != -1 && this.lastMatch == false) {
            displayImage(buttons[this.first], 1);
            turn(buttons);
        }
        this.first = cardnro;
        this.turned = this.first;
        displayImage(buttons[this.first], 1);
        buttons[this.first].setDisable(true);
    }

    /**
     *
     * Second card pick in a round
     * @param buttons array of buttons used as cards in ui
     * @param cardnro a picked card
     * @return a string that indicates, whether there was a match, victory or fail
     */
    public String pickSecond(Button[] buttons, int cardnro) {
        this.second = cardnro;
        this.counter++;
        displayImage(buttons[this.second], 2);
        String result = matchCheck(this.second, buttons);
        if (this.lastMatch == false) {
            buttons[this.first].setDisable(false);
            buttons[this.second].setDisable(false);
        }
        this.turned = -1;
        return result;
    }

    /**
     *
     * Checks if a game is won
     * @return true if the amount of matches found equals to the amount of pairs in game, false otherwise
     */
    public boolean winCheck() {
        return this.matches == this.pairAmount;
    }
    
    /**
     * 
     * @return the amount of rounds in this game 
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     *
     * Checks if picked cards form a pair
     * @param cardnro card that is picked second
     * @param buttons array of buttons used as cards in ui
     * @return a string that indicates, whether there was a match, victory or fail
     */
    public String matchCheck(int cardnro, Button[] buttons) {
        if (this.cards.getPair(this.second) == this.first) {
            if (!this.cardMatches.containsKey(this.first) && !this.cardMatches.containsKey(this.second)) {
                addMatch(this.first, this.second);
                buttons[this.second].setDisable(true);
                buttons[this.first].setDisable(true);
                this.lastMatch = true;
                if (winCheck()) {
                    return "You won!";
                }
                return "Match";
            }
        }
        this.lastMatch = false;
        return "Try again!";
    }

    /**
     *  
     * Turns picked cards around
     * @param buttons array of buttons used as cards in ui
     */
    public void turn(Button[] buttons) {

        buttons[this.first].setGraphic(null);
        buttons[this.second].setGraphic(null);
        buttons[this.first].setStyle("-fx-background-color: #753440; ");
        buttons[this.second].setStyle("-fx-background-color: #753440; ");
    }
    
    /**
     * 
     * @return first turned card 
     */
    public int getTurned() {
        return this.turned;
    }

    /**
     * 
     * Displays image of a button
     * @param button pressed button in the ui
     * @param place indicates if a card was picked first or second
     */
    public void displayImage(Button button, int place) {
        switch (place) {
            case 1:
                button.setGraphic(this.cards.getImage(this.first));
                button.setStyle("-fx-background-color: #ffffff; ");
                break;
            case 2:
                button.setGraphic(this.cards.getImage(this.second));
                button.setStyle("-fx-background-color: #ffffff; ");
                break;
        }

    }
    
    /**
     * Sets the turned card
     * @param number picked card 
     */
    public void setTurned(int number) {
        this.turned = number;
    }

    /**
     * 
     * Adds a match and increases the amount of made matches
     * @param card1 a card picked first
     * @param card2 a card picked second
     */
    public void addMatch(int card1, int card2) {
        this.cardMatches.put(card1, card2);
        this.cardMatches.put(card2, card1);
        this.matches += 1;

    }

    /**
     * 
     *  Used to fetch a wanted pair
     * @param card a card which pair is needed
     * @return pair of this card
     */
    public int getMatch(int card) {
        return this.cardMatches.get(card);
    }
    
    /**
     * 
     * @return the amount of made matches 
     */
    public int getMatchAmount() {
        return this.matches;
    }

    /**
     * 
     * Used at the end of the game to hide all pictures
     * @param buttons array of buttons used as cards in ui
     */
    public void turnAll(Button[] buttons) {
        for (Button button: buttons) {
            button.setGraphic(null);
            button.setStyle("-fx-background-color: #753440; ");
        }
    }
    
    /**
     * 
     * @return the first picked card 
     */
    public int getFirst() {
        return this.first;
    }
}
