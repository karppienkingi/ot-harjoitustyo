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

    /**
     *
     * the amount of needed pictures
     */
    private int amount;

    /**
     *
     * the list where all of the pictures are put
     */
    private ArrayList<Shape> shapes;

    /**
     *
     * An array of available colors
     */
    private Color[] colors;

    /**
     * Constructor for Images
     *
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
     * Returns a list of needed pictures
     *
     * @return list
     */
    public ArrayList getImages() {
        return this.shapes;
    }

    /**
     *
     * Creates a square image
     *
     * @param index indicates the value from colors array, accepts values (0..3)
     */
    private void createRec(int index) {
        Rectangle rec = new Rectangle();
        rec.setWidth(100);
        rec.setHeight(100);
        rec.setFill(color(index));
        this.shapes.add(rec);

    }

    /**
     *
     * Creates a circle
     *
     * @param index indicates the value from colors array, accepts values (0..3)
     */
    private void createCircle(int index) {
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setFill(color(index));
        this.shapes.add(circle);

    }

    /**
     *
     * Creates a triangle
     *
     * @param index indicates the value from colors array, accepts values (0..3)
     */
    private void createTriangle(int index) {
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(100.0, 100.0,
                200.0, 200.0,
                100.0, 200.0);
        triangle.setFill(color(index));
        this.shapes.add(triangle);

    }

    /**
     *
     * Used to color a created shape
     *
     * @param index indicates the value from colors array, accepts values (0..3)
     * @return a color
     */
    private Color color(int index) {
        return this.colors[index];
    }

}
