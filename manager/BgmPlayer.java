package manager;

import app.MyApp;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BgmPlayer {
     static MediaPlayer BgmPlayer;

    public static void BgmStart(){
        Media media=new Media(BgmPlayer.class.getResource("/sounds/02 Preparing The Arena.mp3").toString());
        BgmPlayer=new MediaPlayer(media);
        BgmPlayer.setVolume(0.6);
        BgmPlayer.play();
    }
     public static void BgmSelect(){
        BgmPlayer.stop();
        Media media=new Media(BgmPlayer.class.getResource("/sounds/03 Choose Your Legend.mp3").toString());
        BgmPlayer=new MediaPlayer(media);
        BgmPlayer.setVolume(0.3);
        BgmPlayer.play();
    }

    public static void BgmBattle(){
        BgmPlayer.stop();
        Media media=new Media(BgmPlayer.class.getResource("/sounds/01 Apex Legends Main Theme.mp3").toString());
        BgmPlayer=new MediaPlayer(media);
        BgmPlayer.setVolume(0.2);
        BgmPlayer.play();
    }
    public static void BgmWin(){
        BgmPlayer.stop();
        Media media=new Media(BgmPlayer.class.getResource("/sounds/05 Victory & Lobby Redux.mp3").toString());
        BgmPlayer=new MediaPlayer(media);
        BgmPlayer.setVolume(0.3);
        BgmPlayer.play();
    }

    public static void BgmLose(){
        BgmPlayer.stop();
        Media media=new Media(BgmPlayer.class.getResource("/sounds/02 Preparing The Arena.mp3").toString());
        BgmPlayer=new MediaPlayer(media);
        BgmPlayer.setVolume(0.3);
        BgmPlayer.play();
    }

}
