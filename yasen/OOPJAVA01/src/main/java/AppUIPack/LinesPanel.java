package AppUIPack;

import SocketPack.Stick;

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


    public LinesPanel(LinkedList<Stick> sticks){
        this.sticks = sticks;
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
}


