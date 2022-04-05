/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package services;

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
public class GamelogicTest {
    
    Gamelogic logic;
    
    public GamelogicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        logic = new Gamelogic(6);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of winCheck method, of class Gamelogic.
     */
    @Test
    public void testWinCheck() {
        System.out.println("winCheck");
        Gamelogic instance = null;
        boolean expResult = false;
        boolean result = instance.winCheck();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of MatchCheck method, of class Gamelogic.
     */
    @Test
    public void testMatchCheck() {
        System.out.println("MatchCheck");
        int cardnro = 0;
        Gamelogic instance = null;
        boolean expResult = false;
        boolean result = instance.MatchCheck(cardnro);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
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
