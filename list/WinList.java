package list;

import app.MyApp;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.SceneManager;

public class WinList {
    public static ImageView getWinBg(){
        Image bg = new Image(WinList.class.getResource("/background/champiton.jfif").toExternalForm());
        ImageView bgView=new ImageView(bg);
        bgView.setPreserveRatio(true);
        bgView.setFitWidth(1500);
        bgView.setFitHeight(800);
        bgView.setLayoutX(-180);
        bgView.setLayoutY(-100);
        return bgView;
    }
    public static Button getWinButton(){
        Button returnButton=new Button("戻る");
        returnButton.setPrefWidth(100);
        returnButton.setPrefHeight(50);
        returnButton.setLayoutX(350);
        returnButton.setLayoutY(500);
        returnButton.setOnAction(e-> SceneManager.showStart());
        return  returnButton;
    }

}
