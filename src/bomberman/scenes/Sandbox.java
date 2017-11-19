/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.scenes;

import bomberman.Renderer;
import bomberman.animations.Direction;
import static bomberman.constants.GlobalConstants.canvasHeight;
import static bomberman.constants.GlobalConstants.canvasWidth;
import static bomberman.constants.GlobalConstants.sceneHeight;
import static bomberman.constants.GlobalConstants.sceneWidth;
import bomberman.entity.PlayerEntity;
import javafx.animation.AnimationTimer;

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
    static double tickDuration;

    public static void init() {
        root = new Group();
        s = new Scene(root, sceneWidth, sceneHeight);
        c = new Canvas(canvasWidth, canvasHeight);
        gc = c.getGraphicsContext2D();
    }

    public static double getTickDuration() {
        return tickDuration;
    }

    public static Scene getScene() {
        init();

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);

        final long startNanoTime = System.nanoTime();

        Renderer.init();

        PlayerEntity player = new PlayerEntity();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                tickDuration = (currentNanoTime - startNanoTime) / 1000000000.0;
                gc.clearRect(0, 0, 512, 512);
                player.draw();
                //Change this too see the different sprites and movement in action
                player.move(Direction.DOWN);
            }
        }.start();
        root.getChildren().add(c);
        return s;
    }

    public static GraphicsContext getGraphicsContext() {
        return gc;
    }

    public static Canvas getCanvas() {
        return c;
    }
}
