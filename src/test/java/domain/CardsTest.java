/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

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
    
    public CardsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getPairs method, of class Cards.
     */
    @Test
    public void testGetPairs() {
        System.out.println("getPairs");
        Cards instance = null;
        HashMap<Integer, Integer> expResult = null;
        HashMap<Integer, Integer> result = instance.getPairs();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPair method, of class Cards.
     */
    @Test
    public void testGetPair() {
        System.out.println("getPair");
        int cardnro = 0;
        Cards instance = null;
        int expResult = 0;
        int result = instance.getPair(cardnro);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
