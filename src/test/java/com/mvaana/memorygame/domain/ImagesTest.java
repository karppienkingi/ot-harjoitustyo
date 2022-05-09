/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mvaana.memorygame.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirka
 */
public class ImagesTest {
    
    Images images;
    
    public ImagesTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.images = new Images(3);
    }

    /**
     * Test of getImages method, of class Images.
     */
    @Test
    public void getImagesReturnsCorrectSizeListOnEasy() {
        assertEquals(3, this.images.getImages().size());
    }
    
    @Test
    public void getImagesReturnsCorrectSizeListOnZero() {
        this.images = new Images(1);
        assertEquals(1, this.images.getImages().size());
    }
    
    @Test
    public void getImagesReturnsCorrectSizeListOnMedium() {
        this.images = new Images(6);
        assertEquals(6, this.images.getImages().size());
    }
    
    @Test
    public void getImagesReturnsCorrectSizeListOnHard() {
        this.images = new Images(12);
        assertEquals(12, this.images.getImages().size());
    }
    
}
