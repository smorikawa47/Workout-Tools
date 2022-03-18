import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener {

    private final JMenuItem item1 = new JMenuItem("Stopwatch");
    private final JMenuItem item2 = new JMenuItem("Timer");
    private final JMenuItem item3 = new JMenuItem("How to use");
    private final JMenuItem item4 = new JMenuItem("List");
    private final JMenuItem item5 = new JMenuItem("calendar");

    private final JButton close = new JButton("Close App");

    public Menu() {
        JFrame f = new JFrame("Workout App");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Clock");
        JMenu menu2 = new JMenu("Workout Memo");
//        JMenu menu3 = new JMenu("Calendar");

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);



        menu1.add(item1);
        menu1.add(item2);
        menu2.add(item3);
        menu2.add(item4);
//        menu3.add(item5);
        menuBar.add(menu1);
        menuBar.add(menu2);
//        menuBar.add(menu3);
        menuBar.add(close);

        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("GymBackground.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        f.setJMenuBar(menuBar);
        f.setSize(700, 300);
        f.setVisible(true);
    }

    public void actionPerformed (ActionEvent E) {
        String type;

        if(E.getSource() == item1) {
            type = "s";
            int min = 0;
            int sec = 0;
            int selection = 0;
            new Timer(type, min, sec, selection);
//            t.stopStopwatch();
        }

        if(E.getSource() == item2) {
            type = "t";
            int min = 0;
            int sec = 0;
            int selection = 0;
            boolean isSelectionValid = false;
            boolean isMinValid = false;
            boolean isSecValid = false;

            while(!isSelectionValid) {
                selection = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose your music\n1: Beautiful Mistake - Maroon5\n2: Electric Love - BØRNS\n3: Surprise1!\n4: Surprise2!"));
                if(selection == 1 || selection == 2 || selection == 3 || selection == 4) {
                    isSelectionValid = true;
                }
                else {
                    while(!isSelectionValid) {
                        selection = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalid input\nChoose your music\n1: Beautiful Mistake - Maroon5\n2: Electric Love - BØRNS\n3: Surprise1!\n4: Surprise2!"));
                        if(selection == 1 || selection == 2 || selection == 3 || selection == 4) {
                            isSelectionValid = true;
                        }
                    }
                }
            }

            while(!isMinValid) {
                min = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter minute number (0-60 min):"));
                if(min <= 60 && min >= 0) {
                    isMinValid = true;
                }
                else {
                    while(!isMinValid) {
                        min = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalid input. Enter minute number (0-60 min):"));
                        if(min <= 60 && min >= 0) {
                            isMinValid = true;
                        }
                    }
                }
            }

            if(min == 60) {
                isSecValid = true;
            }

            while(!isSecValid) {
                if(min == 0) {
                    sec = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter second number (1-59 sec):"));
                    if(sec <= 59 && sec >= 1) {
                        isSecValid = true;
                    }
                    else {
                        while(!isSecValid) {
                            sec = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalid input. Enter second number (1-59 sec):"));
                            if(sec <= 59 && sec >= 1) {
                                isSecValid = true;
                            }
                        }
                    }
                }
                else {
                    sec = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter second number (0-59 sec):"));
                    if (sec <= 59 && sec >= 0) {
                        isSecValid = true;
                    } else {
                        while (!isSecValid) {
                            sec = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalid input. Enter second number (0-59 sec):"));
                            if (sec <= 59 && sec >= 0) {
                                isSecValid = true;
                            }
                        }
                    }
                }
            }

            new Timer(type, min, sec, selection);
        }

        if(E.getSource() == item3) {
            new ListManual();
        }

        if(E.getSource() == item4) {
            new WorkoutList();
        }

        close.addActionListener(e -> System.exit(0));
    }
}
