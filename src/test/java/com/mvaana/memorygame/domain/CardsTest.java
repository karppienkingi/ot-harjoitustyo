package com.mvaana.memorygame.domain;

import java.util.HashMap;;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mirka
 */
public class CardsTest {

    Cards cards;
    HashMap<Integer, Integer> matches;

    public CardsTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.cards = new Cards(6);
        this.matches = this.cards.getPairs();
    }

    @Test
    public void getTestPairReturnsRightSizedMap() {
        int expected = 12;
        assertEquals(expected, this.cards.getPairs().size());
    }

    @Test
    public void getPairReturnsCorrect() {
        int pair = this.matches.get(2);
        assertEquals(pair, this.cards.getPair(2));
    }

    @Test
    public void createPairsPairsEveryCard() {
        boolean expected = true;
        for (int i = 0; i < 6; i++) {
            int cardnro = this.matches.get(i); //5
            int pairnro = this.matches.get(cardnro); // 0 i=0
            if (i != pairnro) {
                expected = false;
            }
        }
        assertEquals(expected, true);
    }

}
