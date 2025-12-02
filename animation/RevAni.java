package animation;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class RevAni extends LegendAni {

    public RevAni(boolean isPlayer){
        super(ImageLoader.loadFrames("rev","wait",isPlayer),
                ImageLoader.loadFrames("rev","recovery",isPlayer),
                ImageLoader.loadFrames("rev","attack",isPlayer),
                isPlayer? 10:15,
                isPlayer?20:20,
                isPlayer?35:30,
                isPlayer?26:18,
                isPlayer?84:80);
        this.enemyWidth=250;
        this.enemyHeight=this.enemyWidth/((double)516/752);
        this.enemyY=50;
        this.enemyX=500;
        this.playerWidth=700;
        this.playerHeight=this.playerWidth/((double)416/752);
        this.playerX=-200;
        this.playerY=300;
    }

}

