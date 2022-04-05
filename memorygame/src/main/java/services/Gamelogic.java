/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domain.Cards;
import java.util.HashMap;

/**
 *
 * @author Mirka
 */
public class Gamelogic {

    private Cards cards;
    public int chosenCard;
    private int turned;
    private final int pairAmount;
    private int matches;
    private HashMap<Integer, Integer> cardMatches;

    public Gamelogic(int amountOfPairs) {

        this.cardMatches = new HashMap<>();
        this.pairAmount = amountOfPairs;
        this.chosenCard = 0;
        this.turned = 0;
        this.matches = 0;
        this.cards = new Cards(amountOfPairs);
    }

    private void addMatch(int card1, int card2) {
        if (!this.cardMatches.containsKey(card1) && !this.cardMatches.containsKey(card2)) {
            System.out.println("MATCH");
            this.cardMatches.put(card1, card2);
            this.cardMatches.put(card2, card1);
            this.matches += 1;
        } else {
            System.out.println("This pair has already been found");
        }
    }

    public boolean winCheck() {
        if (this.matches == this.pairAmount) {
            System.out.println("YOU WON");
            return true;
        }
        return false;
    }

    public boolean MatchCheck(int cardnro) {
        if (cards.getPair(cardnro) == chosenCard) {
            addMatch(chosenCard, cardnro);
            winCheck();
            return true;
        }
        System.out.println("TRY AGAIN");
        return false;
    }
    
    public void setTurned(int number) {
        this.turned = number;
    }

    public int getTurned() {
        return this.turned;
    }

}
