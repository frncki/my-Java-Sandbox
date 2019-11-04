import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class MitosisPanel extends JPanel implements Runnable {

    private boolean active, grow;
    private List<Cell> cells;

    MitosisPanel() {
        this.setPreferredSize(new Dimension(1200, 1200));
        this.setBackground(new Color(51, 51, 51));
        cells = new ArrayList<>(0);
        active = true;
        grow = false;
    }

    void setGrow(boolean g) {
        grow = g;
    }

    void addCell(int x, int y) {
        int radius = 4;
        if (x < radius) x = radius / 2;
        if (x > this.getWidth() - radius) x = this.getWidth() - radius / 2;
        if (y < radius) y = radius / 2;
        if (y > this.getHeight() - radius) y = this.getHeight() - radius / 2;
        System.out.println("x: " + x + " y: " + y);
        cells.add(new Cell(x, y, radius, randomSpeed(3), randomSpeed(3)));
    }

    void splitCell(Cell cell) {
        System.out.println("Splitin");
        int xPos = cell.getX();
        int yPos = cell.getY();
        int radius = cell.getR() / 2;
        cells.remove(cell);
        cells.add(new Cell(xPos - radius, yPos - radius, radius, randomSpeed(5), randomSpeed(5)));
        cells.add(new Cell(xPos + radius, yPos + radius, radius, randomSpeed(5), randomSpeed(5)));

    }

    List<Cell> getCells() {
        return cells;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Cell cell : cells) {
            cell.paint(g);
        }

    }

    private int randomSpeed(int max) {
        int direction = Math.random() < 0.5 ? -1 : 1;
        return (int) ((Math.random() * max) + 1) * direction;
    }


    @Override
    public void run() {
        while (active) {

            for (Cell cell : cells) {
                if (grow) {
                    cells.get(0).grow(this);
                } else {
                    cell.move();
                    cell.bounce(this);
                }

                repaint();
            }

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
