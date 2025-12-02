package scene;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import list.WinList;
import manager.BgmPlayer;

public class WinScene {
    public static Scene getWinScene(int wW,int wH){
       BgmPlayer.BgmWin();
        Pane root =new Pane();
        root.getChildren().addAll(WinList.getWinBg(), WinList.getWinButton());
        return new Scene(root,wW,wH);
    }
}
