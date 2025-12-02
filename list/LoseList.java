package list;

import app.MyApp;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.SceneManager;

public class LoseList {
    public static ImageView getLoseBg(){
        Image bg=new Image(LoseList.class.getResource("/background/lose.jpg").toExternalForm());
        ImageView bgView=new ImageView(bg);
        bgView.setPreserveRatio(true);
        bgView.setFitWidth(1100);
        bgView.setFitHeight(600);
        bgView.setLayoutX(-135);
        return bgView;
    }
    public static Button getLoseButton(){
        Button returnButton=new Button("戻る");
        returnButton.setPrefWidth(100);
        returnButton.setPrefHeight(50);
        returnButton.setLayoutX(350);
        returnButton.setLayoutY(500);
        returnButton.setOnAction(e-> SceneManager.showStart());
        return  returnButton;
    }


}
