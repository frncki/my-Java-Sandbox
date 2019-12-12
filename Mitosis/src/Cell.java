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

    int getX() {
        return this.xPos;
    }

    int getY() {
        return this.yPos;
    }

    int getR() {
        return r;
    }

    private void changeVx() {
        this.vx *= -1;
    }

    private void changeVy() {
        this.vy *= -1;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xPos - r, yPos - r, 2 * r, 2 * r);
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

    boolean isColliding(Cell other) {
        double dx = xPos - other.getX();
        double dy = yPos - other.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);

        if (dist > (r + other.getR())) {
            // No solutions, the circles are too far apart.
            return false;
        } else if (dist <= r + other.getR()) {
            // One circle contains the other.
            return true;
        } else if ((dist == 0) && (r == other.getR())) {
            // the circles coincide.
            return true;
        } else return true;
    }

    void resolveCollision(Cell other) {
        double collisionAngle = Math.atan2((other.getY() - this.yPos), (other.getX() - this.xPos));
        double thisV = this.getSpeed();
        double otherV = other.getSpeed();

        double direction_1 = Math.atan2(this.v.Y, this.v.X);
        double direction_2 = Math.atan2(other.v.Y, other.v.X);
        double new_xspeed_1 = thisV * Math.cos(direction_1 - collisionAngle);
        double new_yspeed_1 = thisV * Math.sin(direction_1 - collisionAngle);
        double new_xspeed_2 = otherV * Math.cos(direction_2 - collisionAngle);
        double new_yspeed_2 = otherV * Math.sin(direction_2 - collisionAngle);

        double final_xspeed_1 = ((this.m - other.m) * new_xspeed_1 + (other.m + other.m) * new_xspeed_2) / (this.m + other.m);
        double final_xspeed_2 = ((this.m + this.m) * new_xspeed_1 + (other.m - this.m) * new_xspeed_2) / (this.m + other.m);
        double final_yspeed_1 = new_yspeed_1;
        double final_yspeed_2 = new_yspeed_2;

        double cosAngle = Math.Cos(collisionAngle);
        double sinAngle = Math.Sin(collisionAngle);
        this.v.X = cosAngle * final_xspeed_1 - sinAngle * final_yspeed_1;
        this.v.Y = sinAngle * final_xspeed_1 + cosAngle * final_yspeed_1;
        other.v.X = cosAngle * final_xspeed_2 - sinAngle * final_yspeed_2;
        other.v.Y = sinAngle * final_xspeed_2 + cosAngle * final_yspeed_2;

        Vector pos1 = new Vector(this.p.X, this.p.Y);
        Vector pos2 = new Vector(other.p.X, other.p.Y);

        // get the mtd
        Vector posDiff = pos1 - pos2;
        double d = posDiff.Length;

        // minimum translation distance to push balls apart after intersecting
        Vector mtd = posDiff * (((this.r + other.r) - d) / d);

        // resolve intersection --
        // computing inverse mass quantities
        double im1 = 1 / this.m;
        double im2 = 1 / other.m;

        // push-pull them apart based off their mass
        pos1 = pos1 + mtd * (im1 / (im1 + im2));
        pos2 = pos2 - mtd * (im2 / (im1 + im2));
        this.p = pos1;
        other.p = pos2;

        if (((this.p.X + this.r) >= canv.Width) | ((this.p.X - this.r) <= 0))
            this.v.X = -1 * this.v.X;

        if (((this.p.Y + this.r) >= canv.Height) | ((this.p.Y - this.r) <= 0))
            this.v.Y = -1 * this.v.Y;

        if (((other.p.X + other.r) >= canv.Width) | ((other.p.X - other.r) <= 0))
            other.v.X = -1 * other.v.X;

        if (((other.p.Y + other.r) >= canv.Height) | ((other.p.Y - other.r) <= 0))
            other.v.Y = -1 * other.v.Y;
    }

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
        return colors.get((int) (Math.random() * colors.size()));
    }
}
