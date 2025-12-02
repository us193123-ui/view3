package animation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class LifelineAni extends LegendAni {
    public LifelineAni(boolean isPlayer){
        super(ImageLoader.loadFrames("lifeline","wait",isPlayer),
        ImageLoader.loadFrames("lifeline","recovery",isPlayer),
        ImageLoader.loadFrames("lifeline","attack",isPlayer),
                isPlayer? 10:10,
                isPlayer? 25:20,
                isPlayer? 30:30,
                isPlayer? 9:34,
                isPlayer?84:80
                );

        this.enemyWidth=200;
        this.enemyHeight=this.enemyWidth/((double)300/509);
        this.enemyY=50;
        this.enemyX=500;

        this.playerWidth=1000;
        this.playerHeight= this.playerWidth /((double)300/509);
        this.playerX=-350;
        this.playerY=200;
    }
}
