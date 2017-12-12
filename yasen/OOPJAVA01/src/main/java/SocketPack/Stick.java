package SocketPack;

import java.awt.Color;
import java.util.Random;

public class Stick {

    private int x1Coord = 0;
    private int y1Coord = 0;
    private int x2Coord = 0;
    private int y2Coord = 0;
    private Color sColor;
    Random random = new Random();


    public Stick(int coordX1, int coordY1, int coordX2, int coordY2){

        super();
        setX1Coord(coordX1);
        setY1Coord(coordY1);
        setX2Coord(coordX2);
        setY2Coord(coordY2);
        sColor = generateStickColor();
    }

    public Color generateStickColor(){

        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);
    }

    /**
     * Getters and Setters @
     */

    public int getX1Coord() {
        return x1Coord;
    }

    public void setX1Coord(int x1Coord) {
        this.x1Coord = x1Coord;
    }

    public int getY1Coord() {
        return y1Coord;
    }

    public void setY1Coord(int y1Coord) {
        this.y1Coord = y1Coord;
    }

    public int getX2Coord() {
        return x2Coord;
    }

    public void setX2Coord(int x2Coord) {
        this.x2Coord = x2Coord;
    }

    public int getY2Coord() {
        return y2Coord;
    }

    public void setY2Coord(int y2Coord) {
        this.y2Coord = y2Coord;
    }
    public Color getStickColor(){
        return sColor;
    }

    public void setStickColor(Color sColor){
        this.sColor = sColor;
    }
}
