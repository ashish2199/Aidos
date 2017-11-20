/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.scenes;

import static bomberman.constants.GlobalConstants.canvasHeight;
import static bomberman.constants.GlobalConstants.canvasWidth;
import static bomberman.constants.GlobalConstants.sceneHeight;
import static bomberman.constants.GlobalConstants.sceneWidth;

import bomberman.GameLoop;
import bomberman.Renderer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Ashish
 */
public class Sandbox {

    static Scene s;
    static Group root;
    static Canvas c;
    static GraphicsContext gc;


    public static void init() {
        root = new Group();
        s = new Scene(root, sceneWidth, sceneHeight);
        c = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(c);
        gc = c.getGraphicsContext2D();
    }



    public static Scene getScene() {
        init();

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);

        Renderer.init();

        GameLoop.start(gc);

        return s;
    }

    public static GraphicsContext getGraphicsContext() {
        return gc;
    }

    public static Canvas getCanvas() {
        return c;
    }
}
