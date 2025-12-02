package animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;

public class LegendAni {
    public int waitFps;
    public int recoveryFps;
    public int attackFps;
    public ArrayList<Image> waitAni;
    public ArrayList<Image> recoveryAni;
    public ArrayList<Image> attackAni;
    public int startSoundFrame;
    public int endSoundFrame;
    public int enemyWidth;
    public double enemyHeight;
    public int enemyX;
    public int enemyY;
    public ArrayList<Image> playerWaitAni;
    public ArrayList<Image> playerRecoveryAni;
    public ArrayList<Image> playerAttackAni;
    public int playerWidth;
    public double playerHeight;
    public int playerX;
    public int playerY;

    LegendAni(ArrayList<Image> waitFrames, ArrayList<Image> recoveryFrames, ArrayList<Image> attackFrames, int waitFps, int recoveryFps, int attackFps, int startframe, int endframe) {
        this.waitAni = waitFrames;
        this.recoveryAni = recoveryFrames;
        this.attackAni = attackFrames;
        this.waitFps = waitFps;
        this.recoveryFps = recoveryFps;
        this.attackFps = attackFps;
        this.startSoundFrame = startframe;
        this.endSoundFrame = endframe;
    }
}