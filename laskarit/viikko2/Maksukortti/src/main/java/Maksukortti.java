/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author Mirka
 */
public class Maksukortti {
    private double arvo;
    private final double EDULLINEN = 2.5;
    private final double MAUKAS = 4.0;

    public Maksukortti(double arvoaAlussa) {
        this.arvo = arvoaAlussa;
    }

    public void syoEdullisesti() {
        if (this.arvo >= EDULLINEN) {
            this.arvo -= EDULLINEN;
        }
    }

    public void syoMaukkaasti() {
        if (this.arvo >= MAUKAS) {
            this.arvo -= MAUKAS;
        }
    }

    public void lataaRahaa(double rahamaara) {
        if (rahamaara < 0) {
            return;
        }

        this.arvo += rahamaara;
        if (this.arvo > 150) {
            this.arvo = 150;
        }
    }

    @Override
    public String toString() {
        return "Kortilla on rahaa " + this.arvo + " euroa";
    }
}
