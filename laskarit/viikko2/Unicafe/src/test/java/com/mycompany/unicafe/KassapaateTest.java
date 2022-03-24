/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirka
 */
public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti liianVahan;

    public KassapaateTest() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(2000);
        liianVahan = new Maksukortti(100);
    }

    @Test
    public void kassassarahaaOikeaMaara() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void lounaitaMyytyOikeaMaara() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiRahaKasvaa() {
        kassa.syoEdullisesti(640);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiLounaatKasvaa() {
        kassa.syoEdullisesti(640);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiVaihtorahatOikein() {
        kassa.syoEdullisesti(640);
        assertEquals(400, kassa.syoEdullisesti(640));
    }

    @Test
    public void syoEdullisestiRahaEiKasva() {
        kassa.syoEdullisesti(230);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiLounaatEiKasvaa() {
        kassa.syoEdullisesti(230);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiVaihtorahatOikeinKunRahaEiRiita() {
        kassa.syoEdullisesti(230);
        assertEquals(230, kassa.syoEdullisesti(230));
    }
    
    //Maukkaasti käteinen
    
    @Test
    public void syoMaukkaastiRahaKasvaa() {
        kassa.syoMaukkaasti(640);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiLounaatKasvaa() {
        kassa.syoMaukkaasti(640);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiVaihtorahatOikein() {
        kassa.syoMaukkaasti(640);
        assertEquals(240, kassa.syoMaukkaasti(640));
    }

    @Test
    public void syoMaukkastiRahaEiKasva() {
        kassa.syoMaukkaasti(230);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiLounaatEiKasva() {
        kassa.syoMaukkaasti(230);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiVaihtorahatOikeinKunRahaEiRiita() {
        kassa.syoMaukkaasti(230);
        assertEquals(230, kassa.syoEdullisesti(230));
    }
    
    //Kortit
    @Test
    public void syoEdullisestiVeloitetaanOikeaMaara() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1760, kortti.saldo());
    }

    @Test
    public void syoEdullisestiPalauttaaTrue() {

        assertTrue(kassa.syoEdullisesti(kortti));
    }

    @Test
    public void syoEdullisestiKortillaLounaatKasvaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiEiVeloita() {
        kassa.syoEdullisesti(liianVahan);
        assertEquals(100, liianVahan.saldo());
    }

    @Test
    public void syoEdullisestiPalauttaaFalse() {
        assertFalse(kassa.syoEdullisesti(liianVahan));
    }

    @Test
    public void syoEdullisestiKortillaLounaatEiKasva() {
        kassa.syoEdullisesti(liianVahan);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiVeloittaaOikein() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1600, kortti.saldo());
    }

    @Test
    public void syoMaukkaastiPalauttaaTrue() {
        assertTrue(kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void syoMaukkaastiKasvattaaLounaita() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiKortillaEiVeloita() {
        kassa.syoMaukkaasti(liianVahan);
        assertEquals(100, liianVahan.saldo());
    }

    @Test
    public void syoMaukkaastiPalauttaaFalse() {
        assertFalse(kassa.syoMaukkaasti(liianVahan));
    }

    @Test
    public void syoMaukkaastiEiLisaaLounaita() {
        kassa.syoMaukkaasti(liianVahan);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassassaRahaaEiMuutuEdullisesta() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassassaRahaaEiMuutuMaukkaasta() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleOikeaMaara() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(2500,kortti.saldo());
    }
    
    @Test
    public void kortilleLataaminenKasvattaaKassarahaa() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(100500, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivista() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(2000, kortti.saldo());
    }
}
