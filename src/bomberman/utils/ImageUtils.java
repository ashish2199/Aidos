package bomberman.utils;

import javafx.scene.image.Image;

import java.io.File;

public class ImageUtils {
    public static Image loadImage(String path) {
        File file = new File(path);
        System.out.println("Loading Sprite sheet " + file.exists());
        String imagePath = file.getAbsolutePath();
        System.out.println("Before Imagepath " + imagePath);
        if (File.separatorChar == '\\') {
            // From Windows to Linux/Mac
            imagePath=imagePath.replace('/', File.separatorChar);
            imagePath = imagePath.replace("\\", "\\\\");
        } else {
            // From Linux/Mac to Windows
            imagePath=imagePath.replace('\\', File.separatorChar);

        }
        imagePath="file:"+imagePath;
        System.out.println("After Imagepath " + imagePath);

        return new Image(imagePath);
    }
}
