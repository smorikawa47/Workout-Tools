package com.example;
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

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);



        menu1.add(item1);
        menu1.add(item2);
        menu2.add(item3);
        menu2.add(item4);

        menuBar.add(menu1);
        menuBar.add(menu2);

        menuBar.add(close);

        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("../src/com/example/MediaFiles/GymBackground.jpg")))));
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
        }

        if(E.getSource() == item2) {
            type = "t";
            int min;
            int sec;
            int selection;

            Music m = new Music();
            m.setMusic();
            if(m.getMusic() == 0) {
                return;
            }
            selection = m.getMusic();

            Timer t = new Timer();
            t.setTime();
            min = t.getMin();
            sec = t.getSec();

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
