package manager;

import animation.LegendAni;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import legend.Legend;
import scene.*;

public class SceneManager{
    static int wW=800;
    static int wH=600;
    public static Stage stage;


    public static void showStart(){
        stage.setScene(StartScene.getStartScene(wW,wH));
    }

    public static void showSelect(){
        stage.setScene(SelectScene.getSelectScene(wW,wH));
    }

    public static void showBattle(Legend meLegend, Legend compLegend, LegendAni meAni, LegendAni compAni){
        stage.setScene(BattleScene.getBattleScene(meLegend,compLegend,meAni,compAni,wW,wH));
    }

    public static void showWin(){
        stage.setScene(WinScene.getWinScene(wW,wH));
    }
    public static void showLose(){
        stage.setScene(LoseScene.getLoseScene(wW,wH));
    }


    public static void setStage(Stage firstStage){
        stage=firstStage;
    }
}
