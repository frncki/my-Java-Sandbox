import javax.swing.*;
import java.awt.*;
import java.util.*;

class Cell {

    private int xPos, yPos, vx, vy, r;
    private Color color;
    private ArrayList<Color> colors;

    Cell(int xPosition, int yPosistion, int radius, int xVelocity, int yVelocity) {
        r = radius;
        xPos = xPosition - (r/2);
        yPos = yPosistion - (r/2);
        vx = xVelocity;
        vy = yVelocity;
        colors = new ArrayList<>();
        color = new Color(200, 50, 50);
    }

    int getSpeed() {
        //TODO
        return 1;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xPos, yPos, r, r);
    }

    void update() {
        xPos += vx;
        yPos += vy;
    }

    void bounce(JPanel panel) {
        if (xPos + r > panel.getWidth() || xPos < 0) vx *= -1;
        if (yPos + r > panel.getHeight() || yPos < 0) vy *= -1;
    }
}
