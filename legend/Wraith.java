package legend;

import app.MyApp;
import javafx.scene.media.AudioClip;

public class Wraith  extends Legend {
    static AudioClip wraithShot=new AudioClip(Wraith.class.getResource("/sounds/重機関銃を乱射1.mp3").toExternalForm());
    static AudioClip wraithRecovery=new AudioClip(Wraith.class.getResource("/sounds/レイス回復.mp3").toExternalForm());

    public Wraith(){
        super("lifeline",27,0,2,wraithShot,wraithRecovery);
    }
}