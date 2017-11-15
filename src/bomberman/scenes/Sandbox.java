/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.scenes;

import static bomberman.constants.GlobalConstants.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static bomberman.animations.PlayerAnimations.*;

/**
 *
 * @author Ashish
 */
public class Sandbox {

    static Scene s;
    static Group root;

    public static void init() {
        root = new Group();
        s = new Scene(root, sceneWidth, sceneHeight);
    }

    public static Scene getScene() {
        init();

        Canvas c = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = c.getGraphicsContext2D();

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);
        

        walkDownAnimation(gc);

        root.getChildren().add(c);
        return s;
    }
}
