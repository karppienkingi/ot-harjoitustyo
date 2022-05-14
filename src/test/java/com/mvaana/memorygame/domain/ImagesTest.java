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
