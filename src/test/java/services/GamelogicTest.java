/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package services;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mirka
 */
public class GamelogicTest {

    Gamelogic logic;

    public GamelogicTest() {
    }

    @Before
    public void setUp() throws Exception {
        logic = new Gamelogic(6);
    }

    /**
     * Test of setTurned method, of class Gamelogic.
     */
    @Test
    public void testSetTurned() {
        int number = 5;
        logic.setTurned(number);
        assertEquals(number, logic.getTurned());
    }

    /**
     * Test of getTurned method, of class Gamelogic.
     */
    @Test
    public void testGetTurned() {
        int number = 6;
        logic.setTurned(number);
        assertEquals(number, logic.getTurned());
    }

}
