import javax.swing.*;
import java.awt.*;
import java.util.*;

class Cell {

    private int xPos, yPos, vx, vy, r;
    private Color color;
    private ArrayList<Color> colors;

    Cell(int xPosition, int yPosition, int radius, int xVelocity, int yVelocity) {
        r = radius;
        xPos = xPosition;
        yPos = yPosition;
        vx = xVelocity;
        vy = yVelocity;
        colors = fillColorsArray();
        color = chooseRandomColor();
    }

    int getSpeed() {
        //TODO
        return 1;
    }

    int getX() {return this.xPos;}

    int getY() {return this.yPos;}

    int getR() {return r;}

    private void changeVx() {
        this.vx *= -1;
    }

    private void changeVy() {
        this.vy *= -1;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xPos - r, yPos - r, 2*r, 2*r);
    }

    void grow(JPanel panel) {
        if (!(xPos + r > panel.getWidth() - 2 || xPos - r < 2)) {
            if (!(yPos + r > panel.getHeight() - 2 || yPos - r < 2)) {
                r += 5;
            }
        }
    }

    void move() {
        xPos += vx;
        yPos += vy;
    }

    void bounce(JPanel panel) {
        if (xPos + r > panel.getWidth() || xPos - r < 0) vx *= -1;
        if (yPos + r > panel.getHeight() || yPos - r < 0) vy *= -1;
    }
/*
    boolean isColliding(Cell other) {
        int dx = xPos - other.getX();
        var dy = yPos - other.getY();
        var dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < r + other.getR()) {

        }
        return false;
    }
*/
    private ArrayList<Color> fillColorsArray() {
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(new Color(230, 50, 50));
        colorList.add(new Color(220, 110, 10));
        colorList.add(new Color(240, 230, 10));
        colorList.add(new Color(20, 100, 20));
        colorList.add(new Color(10, 150, 220));
        colorList.add(new Color(120, 40, 190));
        return colorList;
    }

    private Color chooseRandomColor() {
        return colors.get((int)(Math.random() * colors.size()));
    }
}
