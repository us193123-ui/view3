package app;
import manager.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
public class MyApp extends Application {
    public void start (Stage stage){
        SceneManager.setStage(stage);
        SceneManager.showStart();
        stage.show();
        System.out.println("test");
    }

    public static void main(String[] args){
        launch(args);
    }
}
