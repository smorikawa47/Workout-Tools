package com.example;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Music {
    private int selection;

    public Music() {}

    public Object setMusic() {
        selection = 0;

        String[] options = {"Beautiful Mistake - Maroon5", "Electric Love - BØRNS", "Surprise!"};
        Object music = JOptionPane.showInputDialog(null, "Choose your music", "Input", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (music == "Beautiful Mistake - Maroon5") {
            selection = 1;
        }
        else if (music == "Electric Love - BØRNS") {
            selection = 2;
        }
        else if (music == "Surprise!") {
            selection = 3;
        }

        return music;
    }

    public int getMusic() {
        return this.selection;
    }

    public void playMusic(String musicLocation) { 
        try {
            File musicPath = new File(musicLocation);
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                JOptionPane.showMessageDialog(null, "Time is up! Press OK to close timer");
                clip.stop();
                clip.setMicrosecondPosition(0);
                clip.close();
            }
            else {
                System.out.println("Cannot find the file");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
