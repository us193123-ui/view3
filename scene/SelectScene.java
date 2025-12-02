package scene;

import animation.LegendAni;
import animation.LifelineAni;
import animation.RevAni;
import animation.WraithAni;
import app.MyApp;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import legend.Legend;
import legend.Lifeline;
import legend.Rev;
import legend.Wraith;
import list.BattleList;
import list.SelectList;
import manager.BgmPlayer;
import manager.SceneManager;

public class SelectScene {
    static Legend meLegend;
    static Legend compLegend;
    static LegendAni meLegendAni;
    static LegendAni compLegendAni;
    public static Scene getSelectScene(int wW,int wH){
        BgmPlayer.BgmSelect();
        Pane root =new Pane();
        ImageView BG=(SelectList.getSelectBackGround());
        Label label= SelectList.getSelectLabel();
        Button testButton= SelectList.getSelectTestButton();
        //rev
        ImageView revView= SelectList.getRev();
        selectButton("rev",revView,label,wW,wH); //ボタンの無効化、ラベルの変更、敵の選択へ
        //lifeline
        ImageView lifelineView= SelectList.getLifeline();
        selectButton("lifeline",lifelineView,label,wW,wH);
        //wraith
        ImageView wraithView= SelectList.getWraith();
        selectButton("wraith",wraithView,label,wW,wH);

        root.getChildren().addAll(BG,label,revView,wraithView,lifelineView);

        return new Scene(root,wW,wH);
    }

    public static void selectButton(String name,ImageView legendView,Label label,int wW,int wH){
        AudioClip selectSound=new AudioClip(SelectScene.class.getResource("/sounds/決定ボタンを押す10.mp3").toExternalForm());
        legendView.setOnMouseClicked(e -> {
            selectSound.play();
            legendView.setScaleX(0.95);
            legendView.setScaleY(0.95);
            legendView.setOpacity(0.4);
            legendView.setDisable(true);
            //進行
            if (name.equals("rev"))
                if (meLegend == null) {
                    meLegend = new Rev();
                    meLegendAni=new RevAni(true);
                    label.setText("敵のキャラを選択");
                } else {
                    PauseTransition pause3=new PauseTransition(Duration.seconds(1));
                    compLegend = new Rev();
                    compLegendAni=new RevAni(false);
                    pause3.play();
                    pause3.setOnFinished(ev-> SceneManager.showBattle(meLegend,compLegend,meLegendAni,compLegendAni));
                }


            else if(name.equals("lifeline")){
                if (meLegend == null) {
                    meLegend = new Lifeline();
                    meLegendAni=new LifelineAni(true);
                    label.setText("敵のキャラを選択");
                } else {
                    PauseTransition pause1=new PauseTransition(Duration.seconds(1));
                    compLegend = new Lifeline();
                    compLegendAni=new LifelineAni(false);
                    pause1.play();
                    pause1.setOnFinished(ev-> SceneManager.showBattle(meLegend,compLegend,meLegendAni,compLegendAni));
                    }
            }

            else if(name.equals("wraith")){
                if (meLegend == null) {
                    meLegend = new Wraith();
                    meLegendAni=new WraithAni(true);
                    label.setText("敵のキャラを選択");
                }
                else {
                    PauseTransition pause2=new PauseTransition(Duration.seconds(1));
                    compLegend = new Wraith();
                    compLegendAni=new WraithAni(false);
                    pause2.setOnFinished(ev-> SceneManager.showBattle(meLegend,compLegend,meLegendAni,compLegendAni));
                    pause2.play();
                }
            }

        });
    }
}


