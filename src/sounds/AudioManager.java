package sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

/**
 * Created by lhhie on 2/25/2017.
 */
public class AudioManager {
    public static Clip getClip(String name){
        URL url=AudioManager.class.getResource("/sounds/"+name);
        try {
            AudioInputStream stream= AudioSystem.getAudioInputStream(url);
            Clip clip=AudioSystem.getClip();
            clip.open(stream);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
