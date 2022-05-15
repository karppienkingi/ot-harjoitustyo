package com.mvaana.memorygame.domain;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Mirka 
 * A class used to create needed pictures
 */
public class Images {

    private int amount;
    private ArrayList<Shape> shapes;
    private Color[] colors;

    /**
     * 
     * Constructor for Images, that creates the pictures based on the number of pairs
     * @param amountOfImages the amount of needed pictures
     */
    public Images(int amountOfImages) {

        this.amount = amountOfImages;
        this.shapes = new ArrayList<>();
        this.colors = new Color[]{Color.PALEVIOLETRED, Color.SLATEBLUE, Color.SEAGREEN, Color.GOLD};

        switch (this.amount) {
            case 1:
                createRec(0);
                break;
            case 3:
                createRec(0);
                createCircle(0);
                createTriangle(0);
                break;
            case 6:
                for (int i = 0; i < 2; i++) {
                    createRec(i);
                    createCircle(i);
                    createTriangle(i);
                }
                break;
            case 12:
                for (int i = 0; i < 4; i++) {
                    createRec(i);
                    createCircle(i);
                    createTriangle(i);
                }
                break;
        }

    }

    /**
     * 
     * Returns a list of needed pictures
     * @return list of shapes
     */
    public ArrayList getImages() {
        return this.shapes;
    }

    private void createRec(int index) {
        Rectangle rec = new Rectangle();
        rec.setWidth(100);
        rec.setHeight(100);
        rec.setFill(color(index));
        this.shapes.add(rec);

    }

    private void createCircle(int index) {
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setFill(color(index));
        this.shapes.add(circle);

    }

    private void createTriangle(int index) {
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(100.0, 100.0,
                200.0, 200.0,
                100.0, 200.0);
        triangle.setFill(color(index));
        this.shapes.add(triangle);

    }

    private Color color(int index) {
        return this.colors[index];
    }

}
