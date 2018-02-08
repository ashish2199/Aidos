package bomberman.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImageUtils {
    // Lets Java do the os binding
    public static Image loadImage(Path path) {
        String basepath = System.getProperty("user.dir");
        Path imagePath = Paths.get("file:", basepath, path.toString());
        return new Image(imagePath.toString());
    }
    public static Image crop(Image img,int x,int y,int w,int h){
        PixelReader reader = img.getPixelReader();
        WritableImage newImage = new WritableImage(reader, x, y, w, h);
        return newImage;
    }
}
