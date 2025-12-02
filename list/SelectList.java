package list;

import app.MyApp;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SelectList {
    public static ImageView getSelectBackGround() {
        Image bg = new Image(SelectList.class.getResource("/background/select.jpg").toExternalForm());
        ImageView bgView = new ImageView(bg);
        bgView.setFitHeight(600);
        bgView.setFitWidth(800);
        bgView.setMouseTransparent(true);
        return bgView;
    }

    public static Button getSelectTestButton() {
        Button testButton = new Button("次へ");
        testButton.setPrefWidth(100);
        testButton.setPrefHeight(50);
        testButton.setLayoutX(350);
        testButton.setLayoutY(500);
        return testButton;
    }

    public static Label getSelectLabel() {
        Label playerHpLabel = new Label("自分のキャラを選択");
        playerHpLabel.setStyle("-fx-font-size:40px; -fx-text-fill: white;");
        playerHpLabel.setLayoutX(0); // 横方向の座標
        playerHpLabel.setLayoutY(0);
        return playerHpLabel;
    }

    public static ImageView getRev() {
        Image rev =new Image(SelectList.class.getResource("/legends/rev/revselect.png").toExternalForm());
        ImageView revView = new ImageView(rev);
        revView.setPreserveRatio(true);
        revView.setFitWidth(900);
        revView.setLayoutX(-100);
        revView.setLayoutY(70);
        revView.setOnMouseEntered(e -> {
            revView.setScaleX(1.05);
            revView.setScaleY(1.05);
        });
        revView.setOnMouseExited(e -> {
            revView.setScaleX(1);
            revView.setScaleY(1);
        });
        return revView;
    }

    public static ImageView getLifeline(){
        Image lifeline=new Image(SelectList.class.getResource("/legends/lifeline/lifelineselect.png").toExternalForm());
        ImageView lifelineView=new ImageView(lifeline);
        lifelineView.setFitWidth(450);
        lifelineView.setPreserveRatio(true);
        lifelineView.setLayoutX(400);
        lifelineView.setLayoutY(50);
        lifelineView.setOnMouseEntered(e-> {
                    lifelineView.setScaleX(1.05);
                    lifelineView.setScaleY(1.05);
        });
        lifelineView.setOnMouseExited(e-> {
            lifelineView.setScaleX(1);
            lifelineView.setScaleY(1);
        });

    return lifelineView;
    }

    public static ImageView getWraith(){
        Image wraith =new Image(SelectList.class.getResource("/legends/wraith/wraithselect.png").toExternalForm());
        ImageView wraithView=new ImageView(wraith);
        wraithView.setPreserveRatio(true);
        wraithView.setFitWidth(700);
        wraithView.setLayoutX(-200);
        wraithView.setLayoutY(100);
        wraithView.setOnMouseEntered(e->{
            wraithView.setScaleX(1.05);
            wraithView.setScaleY(1.05);});
        wraithView.setOnMouseExited(e->{
            wraithView.setScaleX(1);
            wraithView.setScaleY(1);});
        return wraithView;
    }
}
