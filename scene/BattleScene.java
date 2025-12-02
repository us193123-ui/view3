package scene;

import animation.AnimationFactory;
import animation.LegendAni;
import app.MyApp;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaView;
import legend.Legend;
import list.BattleList;
import manager.BgmPlayer;
import manager.GameManager;
import manager.SceneManager;
import ui.LegendUI;

public class BattleScene {
    static Button attackButton= BattleList.getAttackButton();
    static Button recoveryButton= BattleList.getRecoveryButton();
    static ImageView meAnime;
    static ImageView compAnime;
    static Pane root;

    public static Scene getBattleScene(Legend meLegend, Legend compLegend, LegendAni meLegendAni,LegendAni compLegendAni,int wW, int wH){
        //region 細かいやつ
        root=new Pane();
        BgmPlayer.BgmBattle();
        AudioClip Ng=new AudioClip(BattleScene.class.getResource("/sounds/ビープ音4.mp3").toExternalForm());
        AudioClip choice=new AudioClip(BattleScene.class.getResource("/sounds/決定ボタンを押す17.mp3").toExternalForm());
        AudioClip nockDown=new AudioClip(BattleScene.class.getResource("/sounds/apex-legends-knockdown-sound-effect_0xqJePf.mp3").toExternalForm());
        LegendUI mLUI=new LegendUI(meLegend, BattleList.getHpBarMe(), BattleList.getPlayerHpLabel(meLegend),meLegendAni,true);
        LegendUI cLUI =new LegendUI(compLegend,BattleList.getHpBarComp(), BattleList.getCompHpLabel(compLegend),compLegendAni,false);
        //endregion
        mLUI.changeAnimation("wait",null);
        cLUI.changeAnimation("wait",null);
        if(meLegend.getRecoveryCount()<=0||meLegend.getHp()>=100){
            recoveryButton.setOpacity(0.2);
        }

        attackButton.setOnAction(e->{
            choice.play();
            buttonOnOff(true,meLegend);
            GameManager.attack(meLegend,compLegend,cLUI,mLUI);

        });
        recoveryButton.setOnAction(e->{
            System.out.println("RECOVERY BUTTON CLICKED");
            if(meLegend.getRecoveryCount()<=0||meLegend.getHp()>=100){
                Ng.play();
                return;
            }
            else {

                choice.play();
                buttonOnOff(true, meLegend);
                meLegend.recoveryVoice.play();
                GameManager.recovery(meLegend,compLegend,cLUI,mLUI);
            }
        });
        root.getChildren().addAll(BattleList.getBg(wW,wH),mLUI.hpBar,mLUI.hpLabel, cLUI.hpBar, cLUI.hpLabel,attackButton,recoveryButton,mLUI.legendView,cLUI.legendView);
        return new Scene(root,wW,wH);
    }
    public static void buttonOnOff(boolean offTrue, Legend meLegend){
        if(offTrue){//消える
            attackButton.setDisable(true);
            recoveryButton.setDisable(true);
            attackButton.setOpacity(0);
            recoveryButton.setOpacity(0);

        }
        else{// 戻す
            attackButton.setDisable(false);
            recoveryButton.setDisable(false);
            attackButton.setOpacity(0.5);
            recoveryButton.setOpacity(0.5);
            if(meLegend.getRecoveryCount()<=0||meLegend.getHp()>=100){
                recoveryButton.setOpacity(0.2);
            }
        }
    };
    public static void winLoseScene(Boolean result) {
        if(result==null) return;
        else if(result==false){
            SceneManager.showLose();}
        else SceneManager.showWin();

    }


}
