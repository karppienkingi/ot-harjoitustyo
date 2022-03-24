package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }
    
    @Test
    public void saldoPalauttaaOikein() {
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void saldoOnAlussaOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }

    @Test
    public void lataaRahaalataaOikein() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 11.0", kortti.toString());
    }

    @Test
    public void otaRahaaVahentaaOikein() {

        kortti.otaRahaa(50);
        assertEquals("saldo: 9.50", kortti.toString());
    }

    @Test
    public void otaRahaaEiVahennaTurhaan() {
        kortti.otaRahaa(1100);
        assertEquals("saldo: 10.0", kortti.toString());
    }

    @Test
    public void otaRahaaPalauttaaTrue() {
        Boolean tosi = kortti.otaRahaa(50);
        assertTrue(tosi);

    }

    @Test
    public void otaRahaaPalauttaaFalse() {
        
        Boolean epätosi = kortti.otaRahaa(1100);
        assertFalse(epätosi);
    }
}
