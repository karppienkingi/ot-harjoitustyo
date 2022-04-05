package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Mirka
 */
public class Cards {

    Image image;
    Cards pair;
    int numberOfCard;
    private ArrayList<Integer> cards;
    private HashMap<Integer, Integer> pairs;

    public Cards(int amountOfPairs) {
        this.cards = new ArrayList<>();
        this.pairs = new HashMap<>();
        for (int i = 0; i < amountOfPairs * 2; i++) {
            this.cards.add(i);
        }
        createPairs();

    }

    private void createPairs() {
        Collections.shuffle(this.cards);

        for (int i = 0; i < 6; i += 2) {
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
