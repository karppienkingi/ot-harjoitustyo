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
    public int chosenCard;
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
    }

    public boolean winCheck() {
        return this.matches == this.pairAmount;
    }

    public String MatchCheck(int cardnro, Button[] buttons) {
        if (this.cards.getPair(cardnro) == this.chosenCard) {
            if (!this.cardMatches.containsKey(this.chosenCard) && !this.cardMatches.containsKey(cardnro)) {
                addMatch(this.chosenCard, cardnro);
                buttons[this.chosenCard].setDisable(true);
                buttons[cardnro].setDisable(true);
                if (winCheck()) {
                    return "You won!";
                }

                return "Match";
            }
        }
        return "Try again!";
    }

    public void turn(Button[] buttons) {
        buttons[this.turned].setDisable(false);
    }

    public void setTurned(int number) {
        this.turned = number;
    }

    public int getTurned() {
        return this.turned;
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
}
