import javax.sound.sampled.*;
import java.io.*;

public class bgMusic {
    private Clip clip;

    public bgMusic(String musicFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music continuously
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
