package com.mvaana.memorygame.services;

import javafx.scene.control.Button;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mirka
 */
public class GamelogicTest {

    Gamelogic logic;
    Button[] buttons;
    Button a;
    Button b;
    Button c;

    public GamelogicTest() {
    }

    @Before
    public void setUp() throws Exception {
        logic = new Gamelogic(6);
    }

    @Test
    public void testSetTurned() {
        int number = 5;
        logic.setTurned(number);
        assertEquals(number, logic.getTurned());
    }

    @Test
    public void testGetTurned() {
        int number = 6;
        logic.setTurned(number);
        assertEquals(number, logic.getTurned());
    }

    @Test
    public void winChekcReturnsCorrectWhenNoWin() {
        boolean expected = false;
        assertEquals(expected, logic.winCheck());
    }

    @Test
    public void winCheckReturnsCorrectWhenWin() {
        boolean expected = true;

        for (int i = 0; i < 12; i += 2) {
            logic.addMatch(i, i + 1);
        }

        assertEquals(expected, logic.winCheck());
    }

    @Test
    public void addMatchAddsCorrectCardPair() {
        int first = 0;
        int pair = 7;
        logic.addMatch(first, pair);
        assertEquals(first, logic.getMatch(pair));
    }

    @Test
    public void addMatchIncreasesMatchCounter() {
        int expected = 4;
        for (int i = 0; i < 8; i += 2) {
            logic.addMatch(i, i + 1);
        }
        assertEquals(expected, logic.getMatchAmount());
    }

    @Test
    public void getMatchAmountReturnsCorrect() {
        int expected = 0;
        assertEquals(expected, logic.getMatchAmount());
    }
}
