package animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class AnimationFactory {

    public static ImageView createAnime(String legendName, String doing, int fps, boolean repeat) {
        ImageView view = new ImageView();
        int count[] = {0};
        ArrayList<Image> frames = ImageLoader.loadFrames(legendName, doing,true);
        view.setImage(frames.get(0));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds((double) 1 / fps), e -> {
                    view.setImage(frames.get(count[0] % frames.size()));
                    count[0]++;
                })
        );
        if (repeat) {
            timeline.setCycleCount(Animation.INDEFINITE);
        } else {
            timeline.setCycleCount(frames.size());
        }
        view.setUserData(timeline);
        return view;
    }

    public static void startAnime(ImageView view) {
        Timeline tl = (Timeline) view.getUserData();
            tl.playFromStart();

    }
}


