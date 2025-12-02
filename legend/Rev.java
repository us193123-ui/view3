package legend;

import app.MyApp;
import javafx.scene.media.AudioClip;

public class Rev  extends Legend {
    static AudioClip revShot=new AudioClip(Rev.class.getResource("/sounds/machinegun.mp3").toExternalForm());
    static AudioClip revRecovery=new AudioClip(Rev.class.getResource("/sounds/rev回復.mp3").toExternalForm());
    public Rev(){
        super("rev",20,5,3,revShot,revRecovery);
    }
}