package animation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class WraithAni extends LegendAni {
    public WraithAni(boolean isPlayer){

        super(ImageLoader.loadFrames("lifeline","wait",isPlayer),
                ImageLoader.loadFrames("lifeline","recovery",isPlayer),
                ImageLoader.loadFrames("lifeline","attack",isPlayer),
                isPlayer?10:20,
                isPlayer?10:60,
                isPlayer?10:60,
                isPlayer?9:34,
                isPlayer?84:40);
        this.enemyWidth=550;
        this.enemyHeight=this.enemyWidth /((double)269/400);
        this.enemyY=50;
        this.enemyX=300;
        this.playerWidth=400;
        this.playerHeight= this.playerWidth /((double)300/509);
        this.playerX=200;
        this.playerY=50;
    }
}
