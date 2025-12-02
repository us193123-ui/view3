package list;

import animation.AnimationFactory;
import app.MyApp;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import legend.Legend;
import manager.SceneManager;
import scene.BattleScene;

public class BattleList {
    static int wH = 600;//WindowHeight

    public static ImageView getBg(int wW, int wH) {
        Image backGroundImage = new Image(BattleList.class.getResource("/background/エッジ.png").toExternalForm());
        ImageView backGroundView = new ImageView(backGroundImage);
        //ぼかし
        GaussianBlur blur = new GaussianBlur();
        blur.setRadius(10);  // 数値を大きくするとよりぼかす
        backGroundView.setEffect(blur);
        //アスペクト比固定
        backGroundView.setPreserveRatio(true);
        backGroundView.setSmooth(true);
        //サイズの調整
        double scaleFactor = 1.5; // 1.0 = ちょうどフィット、>1で拡大
        backGroundView.setFitWidth(wW * scaleFactor);
        backGroundView.setFitHeight(wH * scaleFactor);
        //位置の調整
        backGroundView.setX(-(backGroundView.getFitWidth() - wW) / 2);
        double actualHeight = backGroundView.getBoundsInParent().getHeight();
        double actualWidth = backGroundView.getBoundsInParent().getWidth();
        backGroundView.setX(-(actualWidth - wW) / 2);
        backGroundView.setY(-(actualHeight - wH) / 2);
        return backGroundView;
    }

    public static Button getWinbutton() {
        Button WinButton = new Button("勝ち");
        WinButton.setPrefWidth(100);
        WinButton.setPrefHeight(50);
        WinButton.setLayoutX(350);
        WinButton.setLayoutY(500);
        WinButton.setOnAction(e -> SceneManager.showWin());
        return WinButton;
    }

    public static Button getLosebutton() {
        Button Loseton = new Button("負け");
        Loseton.setPrefWidth(100);
        Loseton.setPrefHeight(50);
        Loseton.setLayoutX(660);
        Loseton.setLayoutY(500);
        Loseton.setOnAction(e -> SceneManager.showLose());
        return Loseton;
    }

    public static ProgressBar getHpBarMe() {
        ProgressBar hpBarMe = new ProgressBar();
        hpBarMe.setProgress(1);
        hpBarMe.setPrefWidth(300);
        hpBarMe.setPrefHeight(50);
        hpBarMe.setLayoutX(450);
        hpBarMe.setLayoutY(520);
        hpBarMe.setStyle(
                "-fx-accent: white;" +                 // HP部分の色
                        "-fx-control-inner-background: black;"  // 空の部分の色
        );
        return hpBarMe;
    }

    public static ProgressBar getHpBarComp() {
        ProgressBar hpBarComp = new ProgressBar();
        hpBarComp.setProgress(1.0);
        hpBarComp.setPrefWidth(300);
        hpBarComp.setPrefHeight(50);
        hpBarComp.setLayoutX(170);
        hpBarComp.setLayoutY(50);
        hpBarComp.setStyle(
                "-fx-accent: white;" +                 // HP部分の色
                        "-fx-control-inner-background: black;"  // 空の部分の色
        );
        return hpBarComp;
    }


    public static ImageView getMeRevView() {
        Image meRevImage = new Image(BattleList.class.getResource("/legends/rev/revselect.png").toExternalForm());
        ImageView meRevView = new ImageView(meRevImage);
        meRevView.setScaleX(-1);
        meRevView.setPreserveRatio(true);
        meRevView.setFitWidth(500);
        meRevView.setX(-50);
        meRevView.setY(350);
        return meRevView;
    }

    public static ImageView getMeLifelineView() {
        Image meLifelineImage = new Image(BattleList.class.getResource("/legends/lifeline/lifelineme.png").toExternalForm());
        ImageView meLifeLineView = new ImageView(meLifelineImage);
        meLifeLineView.setScaleX(-1);
        meLifeLineView.setPreserveRatio(true);
        meLifeLineView.setFitWidth(600);
        meLifeLineView.setX(-100);
        meLifeLineView.setY(300);
        return meLifeLineView;


    }

    public static ImageView getMeWraithView() {
        Image meWraithImage = new Image(BattleList.class.getResource("/legends/wraith/mewraith.png").toExternalForm());
        ImageView meWraithView = new ImageView(meWraithImage);
        meWraithView.setPreserveRatio(true);
        meWraithView.setScaleX(-1);
        meWraithView.setFitWidth(500); // 適切な幅を設定
        meWraithView.setX(-30);       // 適切なX座標を設定
        meWraithView.setY(360);
        return meWraithView;
    }

    public static Label getPlayerHpLabel(Legend meLegend) {
        Label playerHpLabel = new Label("HP: " + meLegend.getHp() + "回復:" + meLegend.getRecoveryCount());
        playerHpLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        playerHpLabel.setLayoutX(590); // 横方向の座標
        playerHpLabel.setLayoutY(490);
        return playerHpLabel;
    }

    public static Label getCompHpLabel(Legend compLegend) {
        Label compHpLabel = new Label("HP: " + compLegend.getHp() + "回復" + compLegend.getRecoveryCount());
        compHpLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        compHpLabel.setLayoutX(20); // 横方向の座標
        compHpLabel.setLayoutY(50);
        return compHpLabel;
    }

    public static Button getAttackButton() {
        Button attackButton = new Button("攻撃");
        attackButton.setLayoutX(100);
        attackButton.setLayoutY(200);
        attackButton.setPrefWidth(250);
        attackButton.setPrefHeight(150);
        attackButton.setOpacity(0.5);
        attackButton.setStyle(
                "-fx-background-color: blue;" +
                        "-fx-text-fill: white;" +          // 文字色を白に
                        "-fx-font-size: 60px;" +           // 文字サイズを大きく
                        "-fx-background-radius: 10;"  // 角を丸く
        );
        return attackButton;
    }

    public static Button getRecoveryButton() {
        Button recoveryButton = new Button("回復");
        recoveryButton.setLayoutX(450);
        recoveryButton.setLayoutY(200);
        recoveryButton.setPrefWidth(250);
        recoveryButton.setPrefHeight(150);
        recoveryButton.setOpacity(0.5);
        recoveryButton.setStyle(
                "-fx-background-color: Green;" +
                        "-fx-text-fill: white;" +          // 文字色を白に
                        "-fx-font-size: 60px;" +           // 文字サイズを大きく
                        "-fx-background-radius: 10;");
        return recoveryButton;
    }

}

