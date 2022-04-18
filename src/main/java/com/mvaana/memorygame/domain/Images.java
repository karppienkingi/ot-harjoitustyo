/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Mirka
 */
import javafx.scene.image.Image;

public class Images {
    
    //private final Image[] images;
    private int amount;
    private final Image[] imgs;
    
    public Images(int amountOfImages) {

        Image image = new Image(getClass().getResourceAsStream("/main/java/resources/bird2.jpg"));
        this.imgs = new Image[amountOfImages];
        //for (int i=0;i<amountOfImages;i++) {
            //this.imgs[i] = this.images[i];
        //}    
    }
    
    public Image[] getImages() {
        return this.imgs;
    }
    
}
