/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import com.mvaana.memorygame.domain.Cards;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
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
