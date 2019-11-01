import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Prostokaty");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MitosisPanel mitosisPanel = new MitosisPanel();

        f.setSize(mitosisPanel.getPreferredSize());
        Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2 - f.getSize().width/2, dim.height/2 - f.getSize().height/2);

        f.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mitosisPanel.addCell(e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //shit happenin

        ExecutorService exec = Executors.newFixedThreadPool(1);

        exec.execute(mitosisPanel);

        f.add(mitosisPanel);
        f.setVisible(true);
    }
}
