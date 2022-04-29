package com.mvaana.memorygame.services;

import com.mvaana.memorygame.domain.Cards;
import java.util.HashMap;
import javafx.scene.control.Button;

/**
 *
 * @author Mirka
 */
public class Gamelogic {

    private final Cards cards;
    private int first;
    private int second;
    public int chosenCard;
    private boolean lastMatch;
    private int turned;
    private final int pairAmount;
    private int matches;
    private final HashMap<Integer, Integer> cardMatches;

    public Gamelogic(int amountOfPairs) {

        this.cardMatches = new HashMap<>();
        this.pairAmount = amountOfPairs;
        this.chosenCard = 0;
        this.turned = -1;
        this.matches = 0;
        this.cards = new Cards(this.pairAmount);
        this.first = -1;
        this.second = -1;
        this.lastMatch = false;

    }

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

    public String pickSecond(Button[] buttons, int cardnro) {
        this.second = cardnro;
        displayImage(buttons[this.second], 2);
        String result = matchCheck(this.second, buttons);
        if (this.lastMatch == false) {
            buttons[this.first].setDisable(false);
            buttons[this.second].setDisable(false);
        }
        this.turned = -1;
        return result;
    }

    public boolean winCheck() {
        return this.matches == this.pairAmount;
    }

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

    public void turn(Button[] buttons) {

        buttons[this.first].setGraphic(null);
        buttons[this.second].setGraphic(null);
    }

    public int getTurned() {
        return this.turned;
    }

    public void displayImage(Button button, int place) {
        switch (place) {
            case 1:
                button.setGraphic(this.cards.getImage(this.first));
                break;
            case 2:
                button.setGraphic(this.cards.getImage(this.second));
                break;
        }

    }

    public void setTurned(int number) {
        this.turned = number;
    }

    public void setFirst(int number) {
        this.first = number;
    }

    public void setSecond(int number) {
        this.second = number;
    }

    public void addMatch(int card1, int card2) {
        this.cardMatches.put(card1, card2);
        this.cardMatches.put(card2, card1);
        this.matches += 1;

    }

    public int getMatch(int card) {
        return this.cardMatches.get(card);
    }

    public int getMatchAmount() {
        return this.matches;
    }

    public void turnAll(Button[] buttons) {
        for (Button button: buttons) {
            button.setGraphic(null);
        }
    }
}
