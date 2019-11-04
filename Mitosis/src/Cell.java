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
        colors = new ArrayList<>();
        color = new Color(200, 50, 50);
    }

    int getSpeed() {
        //TODO
        return 1;
    }

    int getX() {return xPos;}

    int getY() {return yPos;}

    int getR() {return r;}

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
}
