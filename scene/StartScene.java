package scene;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import list.StartList;
import manager.BgmPlayer;

public class StartScene {
    public static Scene getStartScene(int wW,int wH) {
        BgmPlayer.BgmStart();
        Pane root = new Pane();
        //背景、スタートボタン
        root.getChildren().addAll(StartList.getStartBackGround(wW,wH), StartList.getStartButton());
        return new Scene(root,wW,wH);
    }
}
