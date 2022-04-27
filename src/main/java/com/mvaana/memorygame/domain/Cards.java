package com.mvaana.memorygame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

/**
 *
 * @author Mirka
 */
public class Cards {

    private ArrayList<Shape> images;
    int numberOfCard;
    private final ArrayList<Integer> cards;
    private final HashMap<Integer, Integer> pairs;
    private final HashMap<Integer, Shape> cardsImages;
    private final int amountOfCards;

    public Cards(int amountOfPairs) {
        this.amountOfCards = amountOfPairs * 2;
        this.images = new Images(amountOfPairs).getImages();

        this.cards = new ArrayList<>();
        this.pairs = new HashMap<>();
        this.cardsImages = new HashMap<>();

        for (int i = 0; i < amountOfPairs * 2; i++) {
            this.cards.add(i);
        }
        createPairs();
    }

    private void createPairs() {
        Collections.shuffle(this.cards);

        int j = 0;
        for (int i = 0; i < this.amountOfCards; i += 2) {
            this.pairs.put(this.cards.get(i), this.cards.get(i + 1));
            this.pairs.put(this.cards.get(i + 1), this.cards.get(i));
            this.cardsImages.put(this.cards.get(i), this.images.get(j));
            this.cardsImages.put(this.cards.get(i + 1), this.images.get(j));
            j += 1;
        }
    }

    public HashMap<Integer, Integer> getPairs() {
        return this.pairs;
    }

    public int getPair(int cardnro) {
        return this.pairs.get(cardnro);
    }

    public Shape getImage(int turned) {
        return this.cardsImages.get(turned);
    }

}
