package animation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageLoader {
    static boolean isPlayer;
    public static ArrayList<Image> loadFrames(String legendName,String doing,boolean player){
        isPlayer=player;
        ArrayList<Image> frames=new ArrayList<>();
        int i=0;

        while(true) {
            String path;
            if(isPlayer){
                path = String.format(
                        "/legends/%s/me%s%s/me%s%s%03d.png",
                        legendName,legendName,doing,legendName, doing, i
                );

            }
            else {
                path = String.format(
                        "/legends/%s/%s%s/%s%s%03d.png",
                        legendName, legendName, doing, legendName, doing, i
                );
            }
            if (ImageLoader.class.getResource(path) == null) {
                break;
            }
            Image image = new Image(ImageLoader.class.getResource(path).toExternalForm(),true);
            i++;
            frames.add(image);
        }
        System.out.println("loader:"+frames.size());
        return frames;
    }

}


