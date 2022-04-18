package com.mvaana.memorygame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Mirka
 */
public class Cards {

    private Images images;
    int numberOfCard;
    private final ArrayList<Integer> cards;
    private final HashMap<Integer, Integer> pairs;
    private final int amountOfCards;

    public Cards(int amountOfPairs) {
        this.amountOfCards = amountOfPairs*2;
        this.cards = new ArrayList<>();
        this.pairs = new HashMap<>();
        for (int i = 0; i < amountOfPairs * 2; i++) {
            this.cards.add(i);
        }
        //this.images = new Images(amountOfPairs);
        createPairs();
    }

    private void createPairs() {
        Collections.shuffle(this.cards);

        for (int i = 0; i < this.amountOfCards ; i += 2) {
            pairs.put(this.cards.get(i), this.cards.get(i + 1));
            pairs.put(this.cards.get(i + 1), this.cards.get(i));
        }
    }
    
    public HashMap<Integer, Integer> getPairs() {
        return this.pairs;
    }

    public int getPair(int cardnro) {
        return this.pairs.get(cardnro);
    }

}
