package bomberman.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImageUtils {
    // Lets Java do the os binding
    public static Image loadImage(Path path) {
        //System.out.println(path.toUri().toString());
        return new Image(path.toUri().toString());
    }

    public static Image crop(Image img,int x,int y,int w,int h){
        PixelReader reader = img.getPixelReader();
        WritableImage newImage = new WritableImage(reader, x, y, w, h);
        return newImage;
    }
}
