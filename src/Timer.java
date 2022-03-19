import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Timer {

    private final JFrame window;
    private final JLabel counterLabel;
    Font font1 = new Font("Arial", Font.PLAIN, 70);

    javax.swing.Timer timer;

    private int second, minute;
    private String ddSecond, ddMinute;
    //stopwatch
    private final JButton startButton = new JButton("Start");
    //stopwatch
    private final JButton stopButton = new JButton("Stop");
    //stopwatch
    private final JButton resetButton = new JButton("Reset");

    DecimalFormat dFormat = new DecimalFormat("00");

    JButton close;

    public Timer (String type, int min, int sec, int selection) {

        window = new JFrame("Clock");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        close = new JButton("x");
        menuBar.add(close);
        close.addActionListener(e -> window.dispose());

        counterLabel = new JLabel("");
        counterLabel.setBounds(300, 230, 200, 100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);

        window.add(counterLabel);
        window.setJMenuBar(menuBar);
        window.setVisible(true);

        minute = min;
        second = sec;

        switch (type) {
            case "s" -> {
                counterLabel.setText("00:00");
                startButton.setBounds(300, 400, 100, 50);
                stopButton.setBounds(300, 450, 100, 50);
                resetButton.setBounds(400, 400, 100, 50);
                window.add(startButton);
                window.add(stopButton);
                window.add(resetButton);
                stopwatch();
            }
            case "t" -> {
                if(min >= 10 && sec >= 10) {
                    counterLabel.setText(min + ":" + sec);
                }
                if(min >= 10 && sec < 10) {
                    counterLabel.setText(min + ":0" + sec);
                }
                if(min < 10 && sec >= 10) {
                    counterLabel.setText("0" + min + ":" + sec);
                }
                if(min < 10 && sec < 10) {
                    counterLabel.setText("0" + min + ":0" + sec);
                }
                startButton.setBounds(350, 400, 100, 50);
                stopButton.setBounds(350, 450, 100, 50);
                window.add(startButton);
                window.add(stopButton);
                countdownTimer(selection);
            }
        }
    }

    private void stopwatch() {
        timer = new javax.swing.Timer(1000, e -> {
            second++;
            ddSecond = dFormat.format(second);
            ddMinute = dFormat.format(minute);
            counterLabel.setText(ddMinute + ":" + ddSecond);

            if(second == 60) {
                second = 0;
                minute++;

                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);
            }
        });

        startButton.addActionListener(e -> timer.start());

        stopButton.addActionListener(e -> timer.stop());

        resetButton.addActionListener(e -> {
            timer.stop();
            counterLabel.setText("00:00");
            second = 0;
            minute = 0;
        });

    }

    private void countdownTimer(int selection) {
        timer = new javax.swing.Timer(1000, e -> {
            second--;
            ddSecond = dFormat.format(second);
            ddMinute = dFormat.format(minute);
            counterLabel.setText(ddMinute + ":" + ddSecond);

            if(second == -1) {
                second = 59;
                minute--;

                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);
            }

            if(minute == 0 && second == 0) {
                String filepath = "";
                counterLabel.setText(ddMinute + ":" + ddSecond);
                timer.stop();
                if (selection == 1) {
                    filepath = "beaut.wav";
                }
                if (selection == 2) {
                    filepath = "Electric-love.wav";
                }
                if (selection == 3) {
                    filepath = "Geef.wav";
                }
                Music musicObj = new Music();
                musicObj.playMusic(filepath);
                window.dispose();
            }
        });

        startButton.addActionListener(e -> timer.start());

        stopButton.addActionListener(e -> timer.stop());

    }
}
