package SocketPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.swing.JPanel;

public class LinesPanel extends JPanel implements Serializable {

    Random randomMain = new Random();
    private static final long serialVersionUID = 1L;
    private static LinkedList<Stick> sticks = new LinkedList<Stick>();

    public LinesPanel(){
        DrawSticks();
    }

    public void addStick(int x1, int y1, int x2, int y2){
        sticks.add(new Stick(x1, y1, x2, y2));
        repaint();
    }

    public void removeLastStick() {
        try{
            sticks.remove();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("The number of sticks is zero. Unappropriate exit from the game program.");
            setVisible(false);
        }
    }

    public void clearAllSticks() {
        sticks.clear();
    }

    public void changeColor(){

        sticks.getLast().setStickColor(Color.WHITE);
    }


    public void doDrawing(Graphics g, Stick stick) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(stick.getX1Coord(), stick.getY1Coord(), stick.getX2Coord(), stick.getY2Coord());
    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        for(Stick stick : sticks){
            g.setColor(stick.getStickColor());
            doDrawing(g, stick);
        }
    }

    public void DrawSticks(){

        for (int i = 0; i <= 20; i++) {
            //int test = randomMain.nextInt(180);
            int angle = (60 + randomMain.nextInt(120));
            int x1 = (int) (600/5 + 120 * Math.sin(angle))+200;
            int y1 = (int) (600/5 + 120 * Math.cos(angle))+200;
            int x2 = (int) (x1 + 300 * Math.cos(angle));
            int y2 = (int) (y1 + 200 * Math.sin(angle));
            this.addStick(x1, y1, x2, y2);
        }
    }
}


