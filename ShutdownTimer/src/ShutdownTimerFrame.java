import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShutdownTimerFrame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu, language;
    private JMenuItem polishItem, englishItem, exitItem;


    private JPanel upPanel, centerPanel, centerUpPanel, centerDownPanel, downPanel;
    private JLabel q1Label, daysLabel, hoursLabel, minutesLabel, secondsLabel, q2Label;
    private JTextField daysField, hoursField, minutesField, secondsField;
    private JButton setButton, deleteButton;
    private String[] inscription, polish, english;

    private int input, days, hours, minutes, seconds;
    private static final String cmd = "shutdown ";

    public ShutdownTimerFrame() {
        super("Shutdown Timer 1.0");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        polish = new String[]{"Język", "Polski", "Angielski", "Wyjdź", "Za ile...", "dni:", "godzin:", "minut:", "sekund:", "...ma być wyłączony komputer?", "Ustaw", "Usuń zaplanowane wyłączenie", "Niepoprawne dane!"};
        english = new String[]{"Language", "Polish", "English", "Exit", "In how many...", "days:", "hours:", "minutes:", "seconds:", "...do you want your computer to be shutdown?", "Set", "Delete last scheduling", "Unvalid input data!"};
        inscription = new String[polish.length];

        inscription = polish;

        //------------------Menu
        this.setJMenuBar(menuBar = new JMenuBar());
        menu = new JMenu("Menu");
        menuBar.add(menu);

        language = new JMenu(inscription[0]);
        menu.add(language);

        polishItem = new JMenuItem(inscription[1]);
        polishItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscription = polish;
            }
        });
        language.add(polishItem);

        englishItem = new JMenuItem(inscription[2]);
        englishItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscription = english;
            }
        });
        language.add(englishItem);

        exitItem = new JMenuItem(inscription[3]);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitItem);

        //----------------------panels--------------------
        upPanel = new JPanel();
        upPanel.setLayout(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());

        centerUpPanel = new JPanel();
        centerUpPanel.setLayout(new FlowLayout());

        centerDownPanel = new JPanel();
        centerDownPanel.setLayout(new FlowLayout());

        downPanel = new JPanel();
        downPanel.setLayout(new FlowLayout());


        //----------------------labels--------------------
        q1Label = new JLabel(inscription[4]);

        daysLabel = new JLabel(inscription[5]);

        hoursLabel = new JLabel(inscription[6]);

        minutesLabel = new JLabel(inscription[7]);

        secondsLabel = new JLabel(inscription[8]);

        q2Label = new JLabel(inscription[9]);

        //----------------------textFields--------------------
        daysField = new JTextField(3);
        daysField.setText("0");

        hoursField = new JTextField(2);
        hoursField.setText("0");

        minutesField = new JTextField(2);
        minutesField.setText("0");

        secondsField = new JTextField(2);
        secondsField.setText("0");

        //----------------------buttons--------------------
        setButton = new JButton(inscription[10]);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerUpPanel.setBackground(Color.PINK);
                try {

                    days = Integer.parseInt(daysField.getText());
                    hours = Integer.parseInt(hoursField.getText());
                    minutes = Integer.parseInt(minutesField.getText());
                    seconds = Integer.parseInt(secondsField.getText());
                    if(days < 0 || (hours > 23 || hours < 0) || (minutes > 59 || minutes < 0) || (seconds > 59 || seconds < 0)) {
                        JOptionPane.showMessageDialog(null, inscription[12], "Error", JOptionPane.WARNING_MESSAGE);
                        days = 0;
                        hours = 0;
                        minutes = 0;
                        seconds = 0;
                    } else if (days == 0 &&  hours == 0 && minutes == 0 && seconds == 0) {

                    } else {
                        input = days * 86400 + hours * 3600 + minutes * 60 + seconds;
                        System.out.println(input);
                        runCommand(cmd + "-s -t " + input);
                    }
                } catch(NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, inscription[12], "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        deleteButton = new JButton(inscription[11]);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runCommand(cmd + "-a");
            }
        });

        upPanel.add(centerPanel, BorderLayout.NORTH);
        upPanel.add(centerUpPanel, BorderLayout.CENTER);
        upPanel.add(centerDownPanel, BorderLayout.SOUTH);

        centerPanel.add(q1Label);

        centerUpPanel.add(daysLabel);
        centerUpPanel.add(daysField);
        centerUpPanel.add(hoursLabel);
        centerUpPanel.add(hoursField);
        centerUpPanel.add(minutesLabel);
        centerUpPanel.add(minutesField);
        centerUpPanel.add(secondsLabel);
        centerUpPanel.add(secondsField);

        centerDownPanel.add(q2Label);

        downPanel.add(setButton);
        downPanel.add(deleteButton);

        this.add(upPanel, BorderLayout.NORTH);
        this.add(downPanel, BorderLayout.SOUTH);
    }

    private void runCommand(String CMD) {
        try {
            // Run Windows command
            Process process = Runtime.getRuntime().exec(CMD);

            // Get input streams
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
