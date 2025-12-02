package legend;

import app.MyApp;
import javafx.scene.media.AudioClip;

public class Lifeline  extends Legend {
    static AudioClip lifelineShot=new AudioClip(Lifeline.class.getResource("/sounds/shotgun.mp3").toExternalForm());
    static AudioClip lifelineRecovery=new AudioClip(Lifeline.class.getResource("/sounds/ライフラ回復.mp3").toExternalForm());

    public Lifeline(){
        super("lifeline",12,25,4,lifelineShot,lifelineRecovery);
    }
}