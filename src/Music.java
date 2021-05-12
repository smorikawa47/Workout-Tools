import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Music {
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
