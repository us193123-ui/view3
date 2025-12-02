package ui;
import animation.ImageLoader;
import javafx.animation.Animation;
import animation.LegendAni;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import legend.Legend;
import list.BattleList;

import java.util.ArrayList;

public class LegendUI {
    public Legend legend;
    public LegendAni legendAni;
    public ProgressBar hpBar;
    public Label hpLabel;
    public ImageView legendView=new ImageView();
    public boolean isPlayer;
    public LegendUI(Legend legend, ProgressBar hpBar, Label hpLabel, LegendAni legendAni,boolean isPlayer) {
        this.legend = legend;
        this.legendAni=legendAni;
        this.hpBar = hpBar;
        this.hpLabel=hpLabel;
        this.legendView=new ImageView();
        this.isPlayer=isPlayer;
    }


    public void updateAnimation(int Amount,Runnable afterAnimation) {
        Timeline timeline = new Timeline();
        int startHp=this.legend.getHp();
        int endHp=startHp+Amount;
        int frames;
        frames=Math.abs(Amount); //回復ならそのまま Amount=damageはLegend.attack(マイナス)　ダメージ数によってフレーム数変える
        if (endHp < 0) endHp = 0;
        if (endHp > 100) endHp = 100;

        for (int i = 1; i <= frames; i++) {
            double t=(double)i/frames;//フレームの進み具合
            double nextHp=startHp+Amount*t;

            if (Amount < 0) {
                nextHp = Math.max(endHp, nextHp);
            }

            final double hplamda=nextHp;
            //1フレームあたりの時間。ここでアニメーションの長さ設定　or　フレームダメージ下げてフレームを増やしてフレーム時間を短く(anime時間=frames*時間)
            KeyFrame kf = new KeyFrame(Duration.millis(65 * i), e -> {
                this.hpBar.setProgress(hplamda/ 100.0);
            });// HPUIをフレーム毎に更新更新
            timeline.getKeyFrames().add(kf);
        }
        timeline.setOnFinished(e->{
            afterAnimation.run();
            System.out.println("HP update finished");
        } );
        timeline.play();
    }
    public void changeAnimation(String doing,Runnable afterAction) {
        final int[] count = {0};
        Timeline oldTimeline = (Timeline) legendView.getUserData();
        if (oldTimeline != null) {
            oldTimeline.stop();
            legendView.setUserData(null);
        }
        //region 待機
        if (doing.equals("wait")) {

            ArrayList<Image> frames =this.legendAni.waitAni;
            Timeline tl = new Timeline(
                    new KeyFrame(
                            Duration.seconds((double) 1 / this.legendAni.waitFps),
                            e -> {



                                this.legendView.setImage(frames.get(count[0] % frames.size()));
                                count[0]++;
                            }
                    )
            );
            tl.setCycleCount(-1);
            if (afterAction != null) tl.setOnFinished(e -> afterAction.run());
            this.legendView.setUserData(tl);
            legendView.setPreserveRatio(true);
            int x = isPlayer ? legendAni.playerX : legendAni.enemyX;
            int y = isPlayer ? legendAni.playerY : legendAni.enemyY;
            int width = isPlayer ? legendAni.playerWidth : legendAni.enemyWidth;
            double height=isPlayer ? legendAni.playerHeight :legendAni.enemyHeight;
            legendView.setLayoutX(x);
            legendView.setLayoutY(y);
            legendView.setFitWidth(width);
            legendView.setFitHeight(height);
            if(isPlayer) {
                legendView.setRotationAxis(Rotate.Y_AXIS);
                legendView.setRotate(-40);
            }
            tl.play();

        }
        //endregion
        //region 回復
        else if (doing.equals("recovery")) {
            ArrayList<Image> frames =this.legendAni.recoveryAni;
            Timeline tl = new Timeline(
                    new KeyFrame(
                            Duration.seconds((double) 1 / this.legendAni.recoveryFps),
                            e -> {
                                this.legendView.setImage(frames.get(count[0]));
                                count[0]++;
                            }
                    )
            );
            tl.setCycleCount(frames.size());
            this.legendView.setUserData(tl);
            if (afterAction != null) tl.setOnFinished(e -> afterAction.run());
            legendView.setPreserveRatio(true);
            int x = isPlayer ? legendAni.playerX : legendAni.enemyX;
            int y = isPlayer ? legendAni.playerY : legendAni.enemyY;
            int width = isPlayer ? legendAni.playerWidth : legendAni.enemyWidth;
            double height=isPlayer ? legendAni.playerHeight :legendAni.enemyHeight;
            legendView.setLayoutX(x);
            legendView.setLayoutY(y);
            legendView.setFitWidth(width);
            legendView.setFitHeight(height);
            tl.play();
        }
        //endregion

        //region 攻撃
        else if (doing.equals("attack")) {
            ArrayList<Image> frames = this.legendAni.attackAni;
            System.out.println("attack frames size = " + frames.size());
            Timeline tl = new Timeline(
                    new KeyFrame(
                            Duration.seconds((double) 1 / this.legendAni.attackFps),
                            e -> {
                                if(count[0]==this.legendAni.startSoundFrame){
                                    this.legend.shotSound.play();
                                }
                                if(count[0]==this.legendAni.endSoundFrame){
                                    this.legend.shotSound.stop();
                                }
                                this.legendView.setImage(frames.get(count[0]));
                                count[0]++;
                            }
                    )
            );
            tl.setCycleCount(frames.size());
            this.legendView.setUserData(tl);
            if (afterAction != null) tl.setOnFinished(e -> {afterAction.run();
            System.out.println("finishAttack");});
            legendView.setPreserveRatio(true);
            int x = isPlayer ? legendAni.playerX : legendAni.enemyX;
            int y = isPlayer ? legendAni.playerY : legendAni.enemyY;
            int width = isPlayer ? legendAni.playerWidth : legendAni.enemyWidth;
            double height=isPlayer ? legendAni.playerHeight :legendAni.enemyHeight;
            legendView.setLayoutX(x);
            legendView.setLayoutY(y);
            legendView.setFitWidth(width);
            legendView.setFitHeight(height);

            tl.play();
        }
        //endregion
    }
    public void updateLabel(){
        this.hpLabel.setText("HP: " + this.legend.getHp()+"回復:"+this.legend.getRecoveryCount());
    }

}
